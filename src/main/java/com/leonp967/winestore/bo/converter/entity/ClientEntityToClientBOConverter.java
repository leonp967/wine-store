package com.leonp967.winestore.bo.converter.entity;

import com.leonp967.winestore.bo.ClientBO;
import com.leonp967.winestore.bo.ClientHistoryBO;
import com.leonp967.winestore.entity.ClientEntity;
import com.leonp967.winestore.entity.ClientHistoryEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientEntityToClientBOConverter implements Converter<ClientEntity, ClientBO> {

    private final ClientHistoryEntityToClientHistoryBOConverter historyConverter;

    public ClientEntityToClientBOConverter(ClientHistoryEntityToClientHistoryBOConverter historyConverter) {
        this.historyConverter = historyConverter;
    }

    @Override
    public ClientBO convert(ClientEntity clientEntity) {
        return ClientBO.builder()
                .id(clientEntity.getId())
                .cpf(clientEntity.getCpf())
                .name(clientEntity.getName())
                .history(convertHistory(clientEntity.getHistory()))
                .build();
    }

    private List<ClientHistoryBO> convertHistory(List<ClientHistoryEntity> historyEntity) {
        return historyEntity.stream()
                .map(historyConverter::convert)
                .collect(Collectors.toList());
    }
}
