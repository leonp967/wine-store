package com.leonp967.winestore.entity.converter;

import com.leonp967.winestore.bo.ClientHistoryBO;
import com.leonp967.winestore.bo.SaleItemBO;
import com.leonp967.winestore.entity.ClientHistoryEntity;
import com.leonp967.winestore.entity.SaleItemEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientHistoryBOtoClientHistoryEntityConverter implements Converter<ClientHistoryBO, ClientHistoryEntity> {

    private final SaleItemBOtoSaleItemEntityConverter saleItemConverter;
    private final ClientBOtoClientEntityConverter clientConverter;

    public ClientHistoryBOtoClientHistoryEntityConverter(SaleItemBOtoSaleItemEntityConverter saleItemConverter, ClientBOtoClientEntityConverter clientConverter) {
        this.saleItemConverter = saleItemConverter;
        this.clientConverter = clientConverter;
    }

    @Override
    public ClientHistoryEntity convert(ClientHistoryBO clientHistoryBO) {
        return ClientHistoryEntity.builder()
                .code(clientHistoryBO.getCode())
                .date(clientHistoryBO.getDate())
                .clientCpf(clientHistoryBO.getClientCpf())
                .items(convertItems(clientHistoryBO.getItems(), clientHistoryBO))
                .total(clientHistoryBO.getTotal())
                .build();
    }

    private List<SaleItemEntity> convertItems(List<SaleItemBO> saleItems, ClientHistoryBO clientHistoryBO) {
        return saleItems.stream()
                .map(bo -> {
                    SaleItemEntity entity = saleItemConverter.convert(bo);
                    entity.setHistoryCode(clientHistoryBO.getCode());
                    return entity;
                })
                .collect(Collectors.toList());
    }
}
