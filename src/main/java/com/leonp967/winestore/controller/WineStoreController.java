package com.leonp967.winestore.controller;

import com.leonp967.winestore.bo.BiggestClientBO;
import com.leonp967.winestore.bo.SaleItemBO;
import com.leonp967.winestore.bo.SortedClientBO;
import com.leonp967.winestore.dto.*;
import com.leonp967.winestore.exception.ClientsQueryException;
import com.leonp967.winestore.exception.ResourceNotFoundException;
import com.leonp967.winestore.model.ClientFilter;
import com.leonp967.winestore.model.FilterTypeEnum;
import com.leonp967.winestore.service.WineStoreService;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/wine-store")
public class WineStoreController {

    private final WineStoreService service;
    private final ConversionService conversionService;

    public WineStoreController(WineStoreService service, ConversionService conversionService) {
        this.service = service;
        this.conversionService = conversionService;
    }

    @GetMapping("/clients")
    public ResponseEntity<List<SortedClient>> getOrderedClients(@RequestBody ClientFilter clientFilter) {
        List<SortedClientBO> clients = service.listClientsSorted(clientFilter);
        List<SortedClient> dtos = clients.stream()
                .map(bo -> {
                    if (clientFilter.getFilterType() == FilterTypeEnum.PURCHASES) {
                        return conversionService.convert(bo, PurchaseSortedClientDTO.class);
                    } else {
                        return conversionService.convert(bo, FidelitySortedClientDTO.class);
                    }
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/clients/biggest-purchase")
    public ResponseEntity<BiggestClientDTO> getClientWithBiggestPurchase(@RequestParam("year") Integer year) throws ClientsQueryException {
        BiggestClientBO biggestClientBO = service.getClientWithBiggestPurchase(year);
        return ResponseEntity.ok(conversionService.convert(biggestClientBO, BiggestClientDTO.class));
    }

    @GetMapping("/clients/{cpf}/recommendation")
    public ResponseEntity<SaleItemDTO> getRecommendation(@PathVariable("cpf") String cpf) throws ResourceNotFoundException {
        SaleItemBO saleItemBO = service.getClientRecommendation(cpf);
        return ResponseEntity.ok(conversionService.convert(saleItemBO, SaleItemDTO.class));
    }
}
