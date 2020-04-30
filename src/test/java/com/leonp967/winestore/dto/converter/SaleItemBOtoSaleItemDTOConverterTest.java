package com.leonp967.winestore.dto.converter;

import com.leonp967.winestore.bo.SaleItemBO;
import com.leonp967.winestore.builder.SaleItemBuilder;
import com.leonp967.winestore.dto.SaleItemDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SaleItemBOtoSaleItemDTOConverterTest {

    private static SaleItemBOtoSaleItemDTOConverter converter;

    @BeforeAll
    public static void setUp() {
        converter = new SaleItemBOtoSaleItemDTOConverter();
    }

    @Test
    public void shouldConvertBOtoDTO() {
        SaleItemBO saleItemBO = SaleItemBuilder.buildBO();
        SaleItemDTO expected = SaleItemBuilder.buildDTO();

        SaleItemDTO result = converter.convert(saleItemBO);

        assertThat(result, equalTo(expected));
    }
}