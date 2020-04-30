package com.leonp967.winestore.bo.converter.entity;

import com.leonp967.winestore.bo.ClientBO;
import com.leonp967.winestore.bo.converter.builder.ClientBuilder;
import com.leonp967.winestore.entity.ClientEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class ClientEntityToClientBOConverterTest {
    private static ClientEntityToClientBOConverter converter;

    @BeforeAll
    public static void setUp() {
        SaleItemEntityToSaleItemBOConverter saleItemConverter = new SaleItemEntityToSaleItemBOConverter();
        ClientHistoryEntityToClientHistoryBOConverter clientHistoryConverter = new ClientHistoryEntityToClientHistoryBOConverter(saleItemConverter);
        converter = new ClientEntityToClientBOConverter(clientHistoryConverter);
    }

    @Test
    public void shouldConvertEntitytoBO() {
        ClientEntity clientEntity = ClientBuilder.buildEntity();
        ClientBO expected = ClientBuilder.buildBO();

        ClientBO result = converter.convert(clientEntity);

        assertThat(result, equalTo(expected));
    }
}