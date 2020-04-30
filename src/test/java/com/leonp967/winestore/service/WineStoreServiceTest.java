package com.leonp967.winestore.service;

import com.leonp967.winestore.RecommendationCalculator;
import com.leonp967.winestore.bo.ClientBO;
import com.leonp967.winestore.bo.SortedClientBO;
import com.leonp967.winestore.builder.ClientBuilder;
import com.leonp967.winestore.builder.SortedClientBuilder;
import com.leonp967.winestore.client.MockClient;
import com.leonp967.winestore.model.ClientFilter;
import com.leonp967.winestore.model.FilterTypeEnum;
import com.leonp967.winestore.repository.WineStoreRepository;
import com.leonp967.winestore.sorter.FidelityClientsSorter;
import com.leonp967.winestore.sorter.PurchaseClientsSorter;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.ConversionService;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class WineStoreServiceTest {

    private static WineStoreService service;
    private static WineStoreRepository repository;
    private static PurchaseClientsSorter purchaseClientsSorter;

    @BeforeAll
    public static void setUp() {
        repository = mock(WineStoreRepository.class);
        MockClient mockClient = mock(MockClient.class);
        purchaseClientsSorter = mock(PurchaseClientsSorter.class);
        FidelityClientsSorter fidelityClientsSorter = mock(FidelityClientsSorter.class);
        ConversionService conversionService = mock(ConversionService.class);
        RecommendationCalculator recommendationCalculator = mock(RecommendationCalculator.class);
        service = new WineStoreService(repository, mockClient,
                conversionService, purchaseClientsSorter,
                fidelityClientsSorter, recommendationCalculator);
    }

    @Test
    public void shouldListClientsSortedByPurchaseWithoutLimit() {
        ClientBO client = ClientBuilder.buildBOWithHistory();
        ClientBO client2 = ClientBuilder.buildBOWithHistory();

        ClientFilter clientFilter = new ClientFilter();
        clientFilter.setFilterType(FilterTypeEnum.PURCHASES);
        clientFilter.setShouldLimit(false);

        SortedClientBO sortedClientBO = SortedClientBuilder.buildBO();
        sortedClientBO.setValue("240");

        given(repository.findAllClients()).willReturn(Arrays.asList(client, client2));
        given(purchaseClientsSorter.sortClients(any(), any())).
                willReturn(Arrays.asList(sortedClientBO, SortedClientBuilder.buildBO()));

        List<SortedClientBO> result = service.listClientsSorted(clientFilter);

        assertThat(result, Matchers.hasSize(2));
        assertThat(result.get(0).getValue(), equalTo("240"));
    }
}