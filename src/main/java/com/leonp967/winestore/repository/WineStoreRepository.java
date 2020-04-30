package com.leonp967.winestore.repository;

import com.leonp967.winestore.bo.ClientBO;
import com.leonp967.winestore.bo.ClientHistoryBO;
import com.leonp967.winestore.bo.SaleItemBO;
import com.leonp967.winestore.bo.converter.entity.ClientEntityToClientBOConverter;
import com.leonp967.winestore.bo.converter.entity.ClientHistoryEntityToClientHistoryBOConverter;
import com.leonp967.winestore.dao.ClientDAO;
import com.leonp967.winestore.dao.ClientHistoryDAO;
import com.leonp967.winestore.dao.SaleItemDAO;
import com.leonp967.winestore.entity.ClientEntity;
import com.leonp967.winestore.entity.ClientHistoryEntity;
import com.leonp967.winestore.entity.SaleItemEntity;
import com.leonp967.winestore.exception.ClientsQueryException;
import com.leonp967.winestore.exception.ResourceNotFoundException;
import org.springframework.core.convert.ConversionService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class WineStoreRepository {

    private final ClientDAO clientDAO;
    private final ClientHistoryDAO clientHistoryDAO;
    private final ConversionService conversionService;
    private final SaleItemDAO saleItemDAO;

    public WineStoreRepository(ClientDAO clientDAO, ClientHistoryDAO clientHistoryDAO, ClientEntityToClientBOConverter clientConverter, ClientHistoryEntityToClientHistoryBOConverter clientHistoryConverter, ConversionService conversionService, SaleItemDAO saleItemDAO) {
        this.clientDAO = clientDAO;
        this.clientHistoryDAO = clientHistoryDAO;
        this.conversionService = conversionService;
        this.saleItemDAO = saleItemDAO;
    }

    public List<ClientBO> findAllClients() {
        Iterable<ClientEntity> clientEntities = clientDAO.findAll();
        return StreamSupport.stream(clientEntities.spliterator(), false)
                .map(entity -> conversionService.convert(entity, ClientBO.class))
                .collect(Collectors.toList());
    }

    public List<ClientHistoryBO> findHistoriesByYear(Integer year) {
        Iterable<ClientHistoryEntity> clientHistoryEntities =
                clientHistoryDAO.findByDateBetween(LocalDate.of(year, 1, 1),
                                                    LocalDate.of(year + 1, 1, 1));
        return StreamSupport.stream(clientHistoryEntities.spliterator(), false)
                .map(entity -> conversionService.convert(entity, ClientHistoryBO.class))
                .collect(Collectors.toList());
    }

    public void saveAllClients(List<ClientBO> clients) {
        List<ClientEntity> entities = clients.stream()
                .map(bo -> conversionService.convert(bo, ClientEntity.class))
                .collect(Collectors.toList());
        clientDAO.saveAll(entities);
    }

    public void saveAllHistories(List<ClientHistoryBO> histories) throws ClientsQueryException {
        List<ClientHistoryEntity> entities = histories.stream()
                .map(bo -> conversionService.convert(bo, ClientHistoryEntity.class))
                .collect(Collectors.toList());
        try {
            clientHistoryDAO.saveAll(entities);
        } catch(DataIntegrityViolationException ex) {
            throw new ClientsQueryException("Client history references an invalid client!");
        } catch(Exception ex) {
            throw new ClientsQueryException("Unexpected error while saving client histories.", ex);
        }
    }

    public ClientBO findByCpf(String cpf) throws ResourceNotFoundException {
        Optional<ClientEntity> maybeClient = clientDAO.findByCpf(cpf);
        return maybeClient.map(entity -> conversionService.convert(entity, ClientBO.class))
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with given cpf!"));
    }

    public List<SaleItemBO> findAllSaleItems() {
        Iterable<SaleItemEntity> saleItemEntity = saleItemDAO.findAll();
        return StreamSupport.stream(saleItemEntity.spliterator(), false)
                .map(entity -> conversionService.convert(entity, SaleItemBO.class))
                .collect(Collectors.toList());
    }
}
