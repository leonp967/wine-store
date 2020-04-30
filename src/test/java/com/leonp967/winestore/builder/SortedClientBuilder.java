package com.leonp967.winestore.builder;

import com.leonp967.winestore.bo.SortedClientBO;
import com.leonp967.winestore.dto.FidelitySortedClientDTO;
import com.leonp967.winestore.dto.PurchaseSortedClientDTO;

public class SortedClientBuilder {

    private static String VALUE = "1235";

    public static SortedClientBO buildBO() {
        return SortedClientBO.builder()
                .value(VALUE)
                .client(ClientBuilder.buildBOWithoutHistory())
                .build();
    }

    public static FidelitySortedClientDTO buildFidelityDTO() {
        return FidelitySortedClientDTO.builder()
                .value(VALUE)
                .client(ClientBuilder.buildDTO())
                .build();
    }

    public static PurchaseSortedClientDTO buildPurchaseDTO() {
        return PurchaseSortedClientDTO.builder()
                .value(VALUE)
                .client(ClientBuilder.buildDTO())
                .build();
    }
}
