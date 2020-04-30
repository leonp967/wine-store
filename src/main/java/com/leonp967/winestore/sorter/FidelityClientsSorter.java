package com.leonp967.winestore.sorter;

import com.leonp967.winestore.bo.ClientBO;
import com.leonp967.winestore.bo.SortedClientBO;
import com.leonp967.winestore.model.ClientFilter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

@Component
public class FidelityClientsSorter {

    Function<Map.Entry<ClientBO, Integer>, SortedClientBO> mappingFunction = entry ->
            SortedClientBO.builder()
                    .client(entry.getKey())
                    .value(entry.getValue().toString())
                    .build();

    public List<SortedClientBO> sortClients(List<ClientBO> clients, ClientFilter filter) {
        Map<ClientBO, Integer> clientToPurchasesCount = clients.stream()
                .collect(getCollectorByFidelity());

        Stream<Map.Entry<ClientBO, Integer>> sortedClientsStream = clientToPurchasesCount.entrySet()
                .stream()
                .sorted(reverseOrder(comparingInt(Map.Entry::getValue)));

        if (filter.getShouldLimit()) {
            sortedClientsStream = sortedClientsStream.limit(filter.getLimit());
        }

        return sortedClientsStream
                .map(mappingFunction)
                .collect(Collectors.toList());
    }

    private Collector<ClientBO, ?, Map<ClientBO, Integer>> getCollectorByFidelity() {
        return groupingBy(client -> client,
                summingInt(client -> (client.getHistory().size())));
    }
}
