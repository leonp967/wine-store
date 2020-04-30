package com.leonp967.winestore;

import com.leonp967.winestore.bo.ClientBO;
import com.leonp967.winestore.bo.SaleItemBO;
import com.leonp967.winestore.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@Component
public class RecommendationCalculator {

    public SaleItemBO getRecommendation(ClientBO client, List<SaleItemBO> saleItems) throws ResourceNotFoundException {
        Supplier<Stream<SaleItemBO>> supplier = () -> getClientItemsStream(client);
        Stream<SaleItemBO> clientItemsStream = supplier.get();

        List<String> topCategories = clientItemsStream
                .collect(groupingBy(SaleItemBO::getCategory, counting()))
                .entrySet().stream()
                .sorted(reverseOrder(comparingLong(Map.Entry::getValue)))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return topCategories.stream()
                .map(category -> {
                    List<String> topVarieties = getTopVarieties(category, supplier);

                    Stream<Optional<SaleItemBO>> possibleRecommendations =
                            getPossibleRecommendations(saleItems, supplier, category, topVarieties);

                    return possibleRecommendations
                            .filter(Optional::isPresent)
                            .map(Optional::get)
                            .findFirst();
                })
        .filter(Optional::isPresent)
        .map(Optional::get)
        .findFirst()
        .orElseThrow(() -> new ResourceNotFoundException("Recommendation not found for this client!"));
    }

    private Stream<SaleItemBO> getClientItemsStream(ClientBO client) {
        return client.getHistory().stream()
                .flatMap(history -> history.getItems().stream());
    }

    private Stream<Optional<SaleItemBO>> getPossibleRecommendations(List<SaleItemBO> saleItems, Supplier<Stream<SaleItemBO>> clientItemsStream,
                                                                    String category, List<String> topVarieties) {
        return topVarieties.stream()
                .map(variety ->
                        saleItems.stream()
                                .filter(item -> item.getVariety().equals(variety)
                                        && item.getCategory().equals(category)
                                        && clientItemsStream.get().noneMatch(clientItem ->
                                        clientItem.getProductName().equals(item.getProductName())))
                                .findFirst()
                );
    }

    private List<String> getTopVarieties(String category, Supplier<Stream<SaleItemBO>> clientItemsStream) {
        return clientItemsStream.get()
                .filter(item -> item.getCategory().equals(category))
                .collect(groupingBy(SaleItemBO::getVariety, counting()))
                .entrySet().stream()
                .sorted(reverseOrder(comparingLong(Map.Entry::getValue)))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
