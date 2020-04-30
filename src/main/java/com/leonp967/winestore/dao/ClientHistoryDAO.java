package com.leonp967.winestore.dao;

import com.leonp967.winestore.entity.ClientHistoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClientHistoryDAO extends CrudRepository<ClientHistoryEntity, Long> {

    List<ClientHistoryEntity> findByDateBetween(LocalDate fromDate, LocalDate toDate);
}
