package com.leonp967.winestore.bo.converter.entity;

import com.leonp967.winestore.bo.ClientHistoryBO;
import com.leonp967.winestore.builder.ClientHistoryBuilder;
import com.leonp967.winestore.entity.ClientHistoryEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.spy;

public class ClientHistoryEntityToClientHistoryBOConverterTest {

    private static ClientHistoryEntityToClientHistoryBOConverter converter;

    @BeforeAll
    public static void setUp() {
        SaleItemEntityToSaleItemBOConverter saleItemConverter = spy(SaleItemEntityToSaleItemBOConverter.class);
        converter = new ClientHistoryEntityToClientHistoryBOConverter(saleItemConverter);
    }

    @Test
    public void shouldConvertEntitytoBO() {
        ClientHistoryEntity clientHistoryEntity = ClientHistoryBuilder.buildEntity();
        ClientHistoryBO expected = ClientHistoryBuilder.buildBO();

        ClientHistoryBO result = converter.convert(clientHistoryEntity);

        assertThat(result, equalTo(expected));
    }
}