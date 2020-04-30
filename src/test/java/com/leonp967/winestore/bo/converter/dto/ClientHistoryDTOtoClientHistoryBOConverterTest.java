package com.leonp967.winestore.bo.converter.dto;

import com.leonp967.winestore.bo.ClientHistoryBO;
import com.leonp967.winestore.builder.ClientHistoryBuilder;
import com.leonp967.winestore.dto.ClientHistoryDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.spy;

public class ClientHistoryDTOtoClientHistoryBOConverterTest {

    private static ClientHistoryDTOtoClientHistoryBOConverter converter;

    @BeforeAll
    public static void setUp() {
        SaleItemDTOtoSaleItemBOConverter saleItemConverter = spy(SaleItemDTOtoSaleItemBOConverter.class);
        converter = new ClientHistoryDTOtoClientHistoryBOConverter(saleItemConverter);
    }

    @Test
    public void shouldConvertDTOtoBO() {
        ClientHistoryDTO clientHistoryDTO = ClientHistoryBuilder.buildDTO();
        ClientHistoryBO expected = ClientHistoryBuilder.buildBO();

        ClientHistoryBO result = converter.convert(clientHistoryDTO);

        assertThat(result, equalTo(expected));
    }
}