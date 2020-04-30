package com.leonp967.winestore.entity.converter;

import com.leonp967.winestore.bo.SaleItemBO;
import com.leonp967.winestore.entity.SaleItemEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SaleItemBOtoSaleItemEntityConverter implements Converter<SaleItemBO, SaleItemEntity> {

    @Override
    public SaleItemEntity convert(SaleItemBO saleItemBO) {
        return SaleItemEntity.builder()
                .category(saleItemBO.getCategory())
                .country(saleItemBO.getCountry())
                .harvest(saleItemBO.getHarvest())
                .price(saleItemBO.getPrice())
                .productName(saleItemBO.getProductName())
                .variety(saleItemBO.getVariety())
                .build();
    }
}
