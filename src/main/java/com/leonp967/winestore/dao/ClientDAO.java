package com.leonp967.winestore.dao;

import com.leonp967.winestore.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientDAO extends CrudRepository<ClientEntity, Long> {
    Optional<ClientEntity> findByCpf(String cpf);
}
