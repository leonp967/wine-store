package com.leonp967.winestore.bo.converter.dto;

import com.leonp967.winestore.bo.SaleItemBO;
import com.leonp967.winestore.dto.SaleItemDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SaleItemDTOtoSaleItemBOConverter implements Converter<SaleItemDTO, SaleItemBO> {

    @Override
    public SaleItemBO convert(SaleItemDTO saleItemDTO) {
        return SaleItemBO.builder()
                .category(saleItemDTO.getCategory())
                .country(saleItemDTO.getCountry())
                .harvest(saleItemDTO.getHarvest())
                .price(saleItemDTO.getPrice())
                .productName(saleItemDTO.getProductName())
                .variety(saleItemDTO.getVariety())
                .build();
    }
}
