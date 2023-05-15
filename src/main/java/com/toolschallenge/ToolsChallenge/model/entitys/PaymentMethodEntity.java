package com.toolschallenge.ToolsChallenge.model.entitys;


import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "metodo_de_pagamento")
@Data
public class PaymentMethodEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pay_Met")
    private Long idPaymentMethod;
    @Column(name = "tipo")
    private String type;
    @Column(name = "parcelas")
    private Integer installments;
}
