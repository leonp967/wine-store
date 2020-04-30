package com.leonp967.winestore.dto.converter;

import com.leonp967.winestore.bo.SortedClientBO;
import com.leonp967.winestore.dto.FidelitySortedClientDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SortedClientBOtoFidelitySortedClientDTOConverter implements Converter<SortedClientBO, FidelitySortedClientDTO> {

    private final ClientBOtoClientDTOConverter converter;

    public SortedClientBOtoFidelitySortedClientDTOConverter(ClientBOtoClientDTOConverter converter) {
        this.converter = converter;
    }

    @Override
    public FidelitySortedClientDTO convert(SortedClientBO sortedClientBO) {
        return FidelitySortedClientDTO.builder()
                .client(converter.convert(sortedClientBO.getClient()))
                .value(sortedClientBO.getValue())
                .build();
    }
}
