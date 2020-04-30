package com.leonp967.winestore.bo.converter.dto;

import com.leonp967.winestore.bo.ClientHistoryBO;
import com.leonp967.winestore.bo.SaleItemBO;
import com.leonp967.winestore.dto.ClientHistoryDTO;
import com.leonp967.winestore.dto.SaleItemDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientHistoryDTOtoClientHistoryBOConverter implements Converter<ClientHistoryDTO, ClientHistoryBO> {

    private final SaleItemDTOtoSaleItemBOConverter saleItemConverter;

    public ClientHistoryDTOtoClientHistoryBOConverter(SaleItemDTOtoSaleItemBOConverter saleItemConverter) {
        this.saleItemConverter = saleItemConverter;
    }

    @Override
    public ClientHistoryBO convert(ClientHistoryDTO clientHistoryDTO) {
        String clientCpf = clientHistoryDTO.getClient().replaceAll("[^0-9]+", "");
        String clientCpfNumbers = clientCpf.length() > 11 ? clientCpf.substring(1) : clientCpf;
        return ClientHistoryBO.builder()
                .code(clientHistoryDTO.getCode())
                .date(clientHistoryDTO.getDate())
                .items(convertItems(clientHistoryDTO.getItems()))
                .total(clientHistoryDTO.getTotal())
                .clientCpf(clientCpfNumbers)
                .build();
    }

    private List<SaleItemBO> convertItems(List<SaleItemDTO> saleItems) {
        return saleItems.stream()
                .map(saleItemConverter::convert)
                .collect(Collectors.toList());
    }
}
