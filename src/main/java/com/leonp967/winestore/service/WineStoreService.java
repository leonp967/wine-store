package com.leonp967.winestore.service;

import com.leonp967.winestore.RecommendationCalculator;
import com.leonp967.winestore.bo.*;
import com.leonp967.winestore.client.MockClient;
import com.leonp967.winestore.dto.ClientDTO;
import com.leonp967.winestore.dto.ClientHistoryDTO;
import com.leonp967.winestore.exception.ClientsQueryException;
import com.leonp967.winestore.exception.ResourceNotFoundException;
import com.leonp967.winestore.model.ClientFilter;
import com.leonp967.winestore.model.FilterTypeEnum;
import com.leonp967.winestore.sorter.FidelityClientsSorter;
import com.leonp967.winestore.sorter.PurchaseClientsSorter;
import com.leonp967.winestore.repository.WineStoreRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingDouble;

@Service
public class WineStoreService {

    private final WineStoreRepository repository;
    private final MockClient mockClient;
    private final ConversionService conversionService;
    private final PurchaseClientsSorter purchaseSorter;
    private final FidelityClientsSorter fidelityClientsSorter;
    private final RecommendationCalculator recommendationCalculator;

    public WineStoreService(WineStoreRepository repository, MockClient mockClient,
                            ConversionService conversionService, PurchaseClientsSorter purchaseSorter,
                            FidelityClientsSorter fidelityClientsSorter,
                            RecommendationCalculator recommendationCalculator) {
        this.repository = repository;
        this.mockClient = mockClient;
        this.conversionService = conversionService;
        this.purchaseSorter = purchaseSorter;
        this.fidelityClientsSorter = fidelityClientsSorter;
        this.recommendationCalculator = recommendationCalculator;
    }

    @PostConstruct
    private void initialize() throws ClientsQueryException {
        List<ClientDTO> clients = mockClient.getClients();
        List<ClientBO> clientBOS = clients.stream()
                .map(dto -> conversionService.convert(dto, ClientBO.class))
                .collect(Collectors.toList());

        repository.saveAllClients(clientBOS);

        List<ClientHistoryDTO> histories = mockClient.getHistories();
        List<ClientHistoryBO> clientHistoryBOS = histories.stream()
                .map(dto -> conversionService.convert(dto, ClientHistoryBO.class))
                .collect(Collectors.toList());

        repository.saveAllHistories(clientHistoryBOS);
    }

    @Cacheable(value = "sorted-clients", key = "#filter")
    public List<SortedClientBO> listClientsSorted(ClientFilter filter) {
        List<ClientBO> clients = repository.findAllClients();

        if (filter.getFilterType() == FilterTypeEnum.PURCHASES) {
            return purchaseSorter.sortClients(clients, filter);
        } else if (filter.getFilterType() == FilterTypeEnum.FIDELITY) {
            return fidelityClientsSorter.sortClients(clients, filter);
        } else {
            throw new IllegalArgumentException("Invalid filter type!");
        }
    }

    @Cacheable(value = "clients", key = "#year")
    public BiggestClientBO getClientWithBiggestPurchase(Integer year) throws ClientsQueryException {
        List<ClientHistoryBO> historiesByYear = repository.findHistoriesByYear(year);
        return historiesByYear.stream()
                .max(comparingDouble(ClientHistoryBO::getTotal))
                .map(history -> BiggestClientBO.builder()
                                .clientCpf(history.getClientCpf())
                                .purchaseTotal(history.getTotal())
                                .build())
                .orElseThrow(() -> new ClientsQueryException("No history found for the year " + year));
    }

    public SaleItemBO getClientRecommendation(String cpf) throws ResourceNotFoundException {
        ClientBO client = repository.findByCpf(cpf);
        List<SaleItemBO> saleItems = repository.findAllSaleItems();

        return recommendationCalculator.getRecommendation(client, saleItems);
    }
}
