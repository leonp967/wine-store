package com.leonp967.winestore.dto.converter;

import com.leonp967.winestore.bo.BiggestClientBO;
import com.leonp967.winestore.builder.BiggestClientBuilder;
import com.leonp967.winestore.dto.BiggestClientDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

public class BiggestClientBOtoBiggestClientDTOConverterTest {

    private static BiggestClientBOtoBiggestClientDTOConverter converter;

    @BeforeAll
    public static void setUp() {
        converter = new BiggestClientBOtoBiggestClientDTOConverter();
    }

    @Test
    public void shouldConvertBOtoDTO() {
        BiggestClientBO biggestClientBO = BiggestClientBuilder.buildBO();
        BiggestClientDTO expected = BiggestClientBuilder.buildDTO();

        BiggestClientDTO result = converter.convert(biggestClientBO);

        assertThat(result, equalTo(expected));
    }
}