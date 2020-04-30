package com.leonp967.winestore.dto.converter;

import com.leonp967.winestore.bo.ClientBO;
import com.leonp967.winestore.dto.ClientDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClientBOtoClientDTOConverter implements Converter<ClientBO, ClientDTO> {

    @Override
    public ClientDTO convert(ClientBO clientBO) {
        return ClientDTO.builder()
                .cpf(clientBO.getCpf())
                .id(clientBO.getId())
                .name(clientBO.getName())
                .build();
    }
}
