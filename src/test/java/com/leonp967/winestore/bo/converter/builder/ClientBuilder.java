package com.leonp967.winestore.bo.converter.builder;

import com.leonp967.winestore.bo.ClientBO;
import com.leonp967.winestore.dto.ClientDTO;
import com.leonp967.winestore.entity.ClientEntity;

import java.util.Collections;

public class ClientBuilder {

    private static final String NAME = "name";
    private static final String CPF = "11111111111";
    private static final Long ID = 1L;

    public static ClientDTO buildDTO() {
        return ClientDTO.builder()
                .name(NAME)
                .cpf(CPF)
                .id(ID)
                .build();
    }

    public static ClientBO buildBO() {
        return ClientBO.builder()
                .name(NAME)
                .cpf(CPF)
                .id(ID)
                .history(Collections.singletonList(ClientHistoryBuilder.buildBO()))
                .build();
    }

    public static ClientEntity buildEntity() {
        return ClientEntity.builder()
                .name(NAME)
                .cpf(CPF)
                .id(ID)
                .history(Collections.singletonList(ClientHistoryBuilder.buildEntity()))
                .build();
    }
}
