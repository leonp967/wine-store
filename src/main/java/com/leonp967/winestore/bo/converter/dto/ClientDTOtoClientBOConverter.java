package com.leonp967.winestore.bo.converter.dto;

import com.leonp967.winestore.bo.ClientBO;
import com.leonp967.winestore.dto.ClientDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClientDTOtoClientBOConverter implements Converter<ClientDTO, ClientBO> {

    private final ClientHistoryDTOtoClientHistoryBOConverter historyConverter;

    public ClientDTOtoClientBOConverter(ClientHistoryDTOtoClientHistoryBOConverter historyConverter) {
        this.historyConverter = historyConverter;
    }

    @Override
    public ClientBO convert(ClientDTO clientDTO) {
        return ClientBO.builder()
                .id(clientDTO.getId())
                .cpf(clientDTO.getCpf().replaceAll("[^0-9]+", ""))
                .name(clientDTO.getName())
                .build();
    }
}
