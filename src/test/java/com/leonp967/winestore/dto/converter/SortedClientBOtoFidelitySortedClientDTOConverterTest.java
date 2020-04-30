package com.leonp967.winestore.dto.converter;

import com.leonp967.winestore.bo.SortedClientBO;
import com.leonp967.winestore.builder.SortedClientBuilder;
import com.leonp967.winestore.dto.FidelitySortedClientDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SortedClientBOtoFidelitySortedClientDTOConverterTest {

    private static SortedClientBOtoFidelitySortedClientDTOConverter converter;

    @BeforeAll
    public static void setUp() {
        ClientBOtoClientDTOConverter clientBOtoClientDTOConverter = new ClientBOtoClientDTOConverter();
        converter = new SortedClientBOtoFidelitySortedClientDTOConverter(clientBOtoClientDTOConverter);
    }

    @Test
    public void shouldConvertBOtoFidelityDTO() {
        SortedClientBO sortedClientBO = SortedClientBuilder.buildBO();
        FidelitySortedClientDTO expected = SortedClientBuilder.buildFidelityDTO();

        FidelitySortedClientDTO result = converter.convert(sortedClientBO);

        assertThat(result, equalTo(expected));
    }
}