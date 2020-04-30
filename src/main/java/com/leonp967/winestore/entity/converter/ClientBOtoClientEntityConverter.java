package com.leonp967.winestore.entity.converter;

import com.leonp967.winestore.bo.ClientBO;
import com.leonp967.winestore.entity.ClientEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClientBOtoClientEntityConverter implements Converter<ClientBO, ClientEntity> {

    @Override
    public ClientEntity convert(ClientBO clientBO) {
        return ClientEntity.builder()
                .id(clientBO.getId())
                .cpf(clientBO.getCpf())
                .name(clientBO.getName())
                .build();
    }
}
