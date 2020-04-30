package com.leonp967.winestore.builder;

import com.leonp967.winestore.bo.SaleItemBO;
import com.leonp967.winestore.dto.SaleItemDTO;
import com.leonp967.winestore.entity.SaleItemEntity;

public class SaleItemBuilder {

    private static final String PRODUCT_NAME = "product";
    private static final String VARIETY = "variety";
    private static final String COUNTRY = "country";
    private static final String CATEGORY = "category";
    private static final String HARVEST = "harvest";
    private static final Double PRICE = 50d;

    public static SaleItemDTO buildDTO() {
        return SaleItemDTO.builder()
                .variety(VARIETY)
                .productName(PRODUCT_NAME)
                .price(PRICE)
                .harvest(HARVEST)
                .country(COUNTRY)
                .category(CATEGORY)
                .build();
    }

    public static SaleItemBO buildBO() {
        return SaleItemBO.builder()
                .variety(VARIETY)
                .productName(PRODUCT_NAME)
                .price(PRICE)
                .harvest(HARVEST)
                .country(COUNTRY)
                .category(CATEGORY)
                .build();
    }

    public static SaleItemEntity buildEntity() {
        return SaleItemEntity.builder()
                .variety(VARIETY)
                .productName(PRODUCT_NAME)
                .price(PRICE)
                .harvest(HARVEST)
                .country(COUNTRY)
                .category(CATEGORY)
                .build();
    }
}
