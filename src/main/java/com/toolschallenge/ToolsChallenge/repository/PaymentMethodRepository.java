package com.toolschallenge.ToolsChallenge.repository;

import com.toolschallenge.ToolsChallenge.model.entitys.PaymentMethodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethodEntity, Long> {
}
