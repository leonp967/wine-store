package com.leonp967.winestore.bo.converter.entity;

import com.leonp967.winestore.bo.SaleItemBO;
import com.leonp967.winestore.entity.SaleItemEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SaleItemEntityToSaleItemBOConverter implements Converter<SaleItemEntity, SaleItemBO> {

    @Override
    public SaleItemBO convert(SaleItemEntity saleItemEntity) {
        return SaleItemBO.builder()
                .category(saleItemEntity.getCategory())
                .country(saleItemEntity.getCountry())
                .harvest(saleItemEntity.getHarvest())
                .price(saleItemEntity.getPrice())
                .productName(saleItemEntity.getProductName())
                .variety(saleItemEntity.getVariety())
                .build();
    }
}
