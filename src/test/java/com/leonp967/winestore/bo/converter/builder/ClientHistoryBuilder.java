package com.leonp967.winestore.bo.converter.builder;

import com.leonp967.winestore.bo.ClientHistoryBO;
import com.leonp967.winestore.dto.ClientHistoryDTO;
import com.leonp967.winestore.entity.ClientHistoryEntity;

import java.time.LocalDate;
import java.util.Collections;

public class ClientHistoryBuilder {

    private static final String CODE = "code";
    private static final LocalDate DATE = LocalDate.of(2020, 1, 1);
    private static final Double TOTAL = 120d;
    private static final String CLIENT_CPF = "cpf";
    private static final Long CLIENT_ID = 1L;

    public static ClientHistoryDTO buildDTO() {
        return ClientHistoryDTO.builder()
                .client(CLIENT_CPF)
                .code(CODE)
                .date(DATE)
                .items(Collections.singletonList(SaleItemBuilder.buildDTO()))
                .total(TOTAL)
                .build();
    }

    public static ClientHistoryBO buildBO() {
        return ClientHistoryBO.builder()
                .clientCpf(CLIENT_CPF)
                .code(CODE)
                .date(DATE)
                .items(Collections.singletonList(SaleItemBuilder.buildBO()))
                .total(TOTAL)
                .build();
    }

    public static ClientHistoryEntity buildEntity() {
        return ClientHistoryEntity.builder()
                .code(CODE)
                .date(DATE)
                .items(Collections.singletonList(SaleItemBuilder.buildEntity()))
                .total(TOTAL)
                .clientCpf(CLIENT_CPF)
                .build();
    }
}
