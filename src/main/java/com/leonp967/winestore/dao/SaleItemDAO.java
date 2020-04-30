package com.leonp967.winestore.dao;

import com.leonp967.winestore.entity.SaleItemEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SaleItemDAO extends CrudRepository<SaleItemEntity, Long> {
    List<SaleItemEntity> findByVarietyAndCategory(String variety, String category);
}
