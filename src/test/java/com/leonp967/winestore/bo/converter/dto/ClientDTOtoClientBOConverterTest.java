package com.leonp967.winestore.bo.converter.dto;

import com.leonp967.winestore.bo.ClientBO;
import com.leonp967.winestore.builder.ClientBuilder;
import com.leonp967.winestore.dto.ClientDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ClientDTOtoClientBOConverterTest {

    private static ClientDTOtoClientBOConverter converter;

    @BeforeAll
    public static void setUp() {
        SaleItemDTOtoSaleItemBOConverter saleItemConverter = new SaleItemDTOtoSaleItemBOConverter();
        ClientHistoryDTOtoClientHistoryBOConverter clientHistoryConverter = new ClientHistoryDTOtoClientHistoryBOConverter(saleItemConverter);
        converter = new ClientDTOtoClientBOConverter(clientHistoryConverter);
    }

    @Test
    public void shouldConvertDTOtoBO() {
        ClientDTO clientDTO = ClientBuilder.buildDTO();
        ClientBO expected = ClientBuilder.buildBOWithoutHistory();

        ClientBO result = converter.convert(clientDTO);

        assertThat(result, equalTo(expected));
    }
}