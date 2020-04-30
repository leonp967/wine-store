package com.leonp967.winestore.dto.converter;

import com.leonp967.winestore.bo.SaleItemBO;
import com.leonp967.winestore.dto.SaleItemDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SaleItemBOtoSaleItemDTOConverter implements Converter<SaleItemBO, SaleItemDTO> {

    @Override
    public SaleItemDTO convert(SaleItemBO saleItemBO) {
        return SaleItemDTO.builder()
                .category(saleItemBO.getCategory())
                .country(saleItemBO.getCountry())
                .harvest(saleItemBO.getHarvest())
                .price(saleItemBO.getPrice())
                .productName(saleItemBO.getProductName())
                .variety(saleItemBO.getVariety())
                .build();
    }
}
