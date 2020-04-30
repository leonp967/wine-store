package com.leonp967.winestore.bo.converter.entity;

import com.leonp967.winestore.bo.SaleItemBO;
import com.leonp967.winestore.builder.SaleItemBuilder;
import com.leonp967.winestore.entity.SaleItemEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SaleItemEntityToSaleItemBOConverterTest {

    private static SaleItemEntityToSaleItemBOConverter converter;

    @BeforeAll
    public static void setUp() {
        converter = new SaleItemEntityToSaleItemBOConverter();
    }

    @Test
    public void shouldConvertEntitytoBO() {
        SaleItemEntity saleItemEntity = SaleItemBuilder.buildEntity();
        SaleItemBO expected = SaleItemBuilder.buildBO();

        SaleItemBO result = converter.convert(saleItemEntity);

        assertThat(result, equalTo(expected));
    }
}