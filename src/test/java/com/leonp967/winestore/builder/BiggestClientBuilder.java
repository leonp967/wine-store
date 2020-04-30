package com.leonp967.winestore.builder;

import com.leonp967.winestore.bo.BiggestClientBO;
import com.leonp967.winestore.dto.BiggestClientDTO;

public class BiggestClientBuilder {

    private static final Double TOTAL_PURCHASE = 200d;
    private static final String CLIENT_CPF = "1111111";

    public static BiggestClientBO buildBO() {
        return BiggestClientBO.builder()
                .purchaseTotal(TOTAL_PURCHASE)
                .clientCpf(CLIENT_CPF)
                .build();
    }

    public static BiggestClientDTO buildDTO() {
        return BiggestClientDTO.builder()
                .purchaseTotal(TOTAL_PURCHASE)
                .clientCpf(CLIENT_CPF)
                .build();
    }
}
