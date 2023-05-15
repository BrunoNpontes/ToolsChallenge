package com.toolschallenge.ToolsChallenge.model.entitys;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity(name = "transacoes")
@Data
public class TransactionEntity {

    @Id
    @Column(name = "id")
    private Long idTransaction;
    @Column(name = "numero_cartao")
    private String numCard;
    @OneToOne
    @JoinColumn(name = "descricao_id")
    private DescriptionEntity description;
    @OneToOne
    @JoinColumn(name = "metodo_de_pagamento_id")
    private PaymentMethodEntity  paymentMethod;

}
