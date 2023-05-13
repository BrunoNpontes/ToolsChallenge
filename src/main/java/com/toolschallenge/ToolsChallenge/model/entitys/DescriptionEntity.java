package com.toolschallenge.ToolsChallenge.model.entitys;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "descricao")
@Data
public class DescriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idDescription;
    @Column(name = "valor")
    private BigDecimal value;
    @Column(name = "data_hora")
    private LocalDateTime dateTime;
    @Column(name = "estabelecimento")
    private String establishment;
    @Column(name = "nsu")
    private String nsu;
    @Column(name = "codigo_autorizacao")
    private String authCode;
    @Column(name = "status")
    private String statusTransaction;

}
