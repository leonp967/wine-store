package com.leonp967.winestore.bo.converter.entity;

import com.leonp967.winestore.bo.ClientHistoryBO;
import com.leonp967.winestore.bo.SaleItemBO;
import com.leonp967.winestore.entity.ClientHistoryEntity;
import com.leonp967.winestore.entity.SaleItemEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientHistoryEntityToClientHistoryBOConverter implements Converter<ClientHistoryEntity, ClientHistoryBO> {

    private final SaleItemEntityToSaleItemBOConverter saleItemConverter;

    public ClientHistoryEntityToClientHistoryBOConverter(SaleItemEntityToSaleItemBOConverter saleItemConverter) {
        this.saleItemConverter = saleItemConverter;
    }

    @Override
    public ClientHistoryBO convert(ClientHistoryEntity clientHistoryEntity) {
        return ClientHistoryBO.builder()
                .code(clientHistoryEntity.getCode())
                .date(clientHistoryEntity.getDate())
                .clientCpf(clientHistoryEntity.getClientCpf())
                .items(convertItems(clientHistoryEntity.getItems()))
                .total(clientHistoryEntity.getTotal())
                .build();
    }

    private List<SaleItemBO> convertItems(List<SaleItemEntity> saleItems) {
        return saleItems.stream()
                .map(saleItemConverter::convert)
                .collect(Collectors.toList());
    }
}
