package com.leonp967.winestore.sorter;

import com.leonp967.winestore.bo.ClientBO;
import com.leonp967.winestore.bo.ClientHistoryBO;
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
import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

@Component
public class PurchaseClientsSorter {

    Function<Map.Entry<ClientBO, Double>, SortedClientBO> mappingFunction = entry ->
            SortedClientBO.builder()
            .client(entry.getKey())
            .value(entry.getValue().toString())
            .build();

    public List<SortedClientBO> sortClients(List<ClientBO> clients, ClientFilter filter) {
        Map<ClientBO, Double> clientToTotalSpent = clients.stream()
                .collect(getCollectorByPurchasesTotal());

        Stream<Map.Entry<ClientBO, Double>> sortedClientsStream = clientToTotalSpent.entrySet()
                .stream()
                .sorted(reverseOrder(comparingDouble(Map.Entry::getValue)));

        if (filter.getShouldLimit()) {
            sortedClientsStream = sortedClientsStream.limit(filter.getLimit());
        }

        return sortedClientsStream
                .map(mappingFunction)
                .collect(Collectors.toList());
    }

    private Collector<ClientBO, ?, Map<ClientBO, Double>> getCollectorByPurchasesTotal() {
        return groupingBy(client -> client,
                summingDouble(client ->
                        client.getHistory().stream()
                                .mapToDouble(ClientHistoryBO::getTotal)
                                .sum()));
    }
}
