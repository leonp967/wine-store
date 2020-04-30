package com.leonp967.winestore.dto.converter;

import com.leonp967.winestore.bo.SortedClientBO;
import com.leonp967.winestore.builder.SortedClientBuilder;
import com.leonp967.winestore.dto.PurchaseSortedClientDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SortedClientBOtoPurchaseSortedClientDTOConverterTest {

    private static SortedClientBOtoPurchaseSortedClientDTOConverter converter;

    @BeforeAll
    public static void setUp() {
        ClientBOtoClientDTOConverter clientBOtoClientDTOConverter = new ClientBOtoClientDTOConverter();
        converter = new SortedClientBOtoPurchaseSortedClientDTOConverter(clientBOtoClientDTOConverter);
    }

    @Test
    public void shouldConvertBOtoFidelityDTO() {
        SortedClientBO sortedClientBO = SortedClientBuilder.buildBO();
        PurchaseSortedClientDTO expected = SortedClientBuilder.buildPurchaseDTO();

        PurchaseSortedClientDTO result = converter.convert(sortedClientBO);

        assertThat(result, equalTo(expected));
    }
}