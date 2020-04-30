package com.leonp967.winestore.dto.converter;

import com.leonp967.winestore.bo.ClientBO;
import com.leonp967.winestore.builder.ClientBuilder;
import com.leonp967.winestore.dto.ClientDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ClientBOtoClientDTOConverterTest {

    private static ClientBOtoClientDTOConverter converter;

    @BeforeAll
    public static void setUp() {
        converter = new ClientBOtoClientDTOConverter();
    }

    @Test
    public void shouldConvertBOtoDTO() {
        ClientBO clientBO = ClientBuilder.buildBOWithoutHistory();
        ClientDTO expected = ClientBuilder.buildDTO();

        ClientDTO result = converter.convert(clientBO);

        assertThat(result, equalTo(expected));
    }
}