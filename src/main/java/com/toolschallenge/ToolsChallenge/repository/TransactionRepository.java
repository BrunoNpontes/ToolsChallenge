package com.toolschallenge.ToolsChallenge.repository;

import com.toolschallenge.ToolsChallenge.model.entitys.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

}
