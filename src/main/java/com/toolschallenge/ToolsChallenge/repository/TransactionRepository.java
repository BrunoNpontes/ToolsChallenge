package com.toolschallenge.ToolsChallenge.repository;

import com.toolschallenge.ToolsChallenge.model.entitys.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM transacoes t\n" +
            "            INNER JOIN descricao d ON t.descricao_id = d.id_desc\n" +
            "            INNER JOIN metodo_de_pagamento mp ON t.metodo_de_pagamento_id = mp.id_pay_Met \n" +
            "            WHERE d.status = 'CANCELADO'")
    List<TransactionEntity> findChargebackAll();

    @Query(nativeQuery = true, value = "SELECT * FROM transacoes t\n" +
            "            INNER JOIN descricao d ON t.descricao_id = d.id_desc\n" +
            "            INNER JOIN metodo_de_pagamento mp ON t.metodo_de_pagamento_id = mp.id_pay_Met \n" +
            "            WHERE t.id = :id and d.status = 'CANCELADO' ")
    Optional<TransactionEntity> findChargebackById(Long id);
}
