package com.leonp967.winestore.bo.converter.dto;

import com.leonp967.winestore.bo.SaleItemBO;
import com.leonp967.winestore.builder.SaleItemBuilder;
import com.leonp967.winestore.dto.SaleItemDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SaleItemDTOtoSaleItemBOConverterTest {

    private static SaleItemDTOtoSaleItemBOConverter converter;

    @BeforeAll
    public static void setUp() {
        converter = new SaleItemDTOtoSaleItemBOConverter();
    }

    @Test
    public void shouldConvertDTOtoBO() {
        SaleItemDTO saleItemDTO = SaleItemBuilder.buildDTO();
        SaleItemBO expected = SaleItemBuilder.buildBO();

        SaleItemBO result = converter.convert(saleItemDTO);

        assertThat(result, equalTo(expected));
    }
}