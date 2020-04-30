package com.leonp967.winestore.dto.converter;

import com.leonp967.winestore.bo.BiggestClientBO;
import com.leonp967.winestore.dto.BiggestClientDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BiggestClientBOtoBiggestClientDTOConverter implements Converter<BiggestClientBO, BiggestClientDTO> {

    @Override
    public BiggestClientDTO convert(BiggestClientBO biggestClientBO) {
        return BiggestClientDTO.builder()
                .clientCpf(biggestClientBO.getClientCpf())
                .purchaseTotal(biggestClientBO.getPurchaseTotal())
                .build();
    }
}
