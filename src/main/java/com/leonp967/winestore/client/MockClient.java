package com.leonp967.winestore.client;

import com.leonp967.winestore.dto.ClientDTO;
import com.leonp967.winestore.dto.ClientHistoryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "mock-client", url = "http://www.mocky.io/v2")
public interface MockClient {

    @GetMapping("/598b16291100004705515ec5")
    List<ClientDTO> getClients();

    @GetMapping("/598b16861100004905515ec7")
    List<ClientHistoryDTO> getHistories();
}
