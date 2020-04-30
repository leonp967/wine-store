package com.leonp967.winestore.dto.converter;

import com.leonp967.winestore.bo.SortedClientBO;
import com.leonp967.winestore.dto.PurchaseSortedClientDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SortedClientBOtoSortedClientDTOConverter implements Converter<SortedClientBO, PurchaseSortedClientDTO> {

    private final ClientBOtoClientDTOConverter converter;

    public SortedClientBOtoSortedClientDTOConverter(ClientBOtoClientDTOConverter converter) {
        this.converter = converter;
    }

    @Override
    public PurchaseSortedClientDTO convert(SortedClientBO sortedClientBO) {
        return PurchaseSortedClientDTO.builder()
                .client(converter.convert(sortedClientBO.getClient()))
                .value(sortedClientBO.getValue())
                .build();
    }
}
