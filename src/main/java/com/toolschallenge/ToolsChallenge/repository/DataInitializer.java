package com.toolschallenge.ToolsChallenge.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DataInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        jdbcTemplate.execute("INSERT INTO metodo_de_pagamento (tipo, parcelas)\n" +
                "VALUES ('AVISTAB', 3)");

        jdbcTemplate.execute("INSERT INTO descricao (valor, data_hora, estabelecimento, nsu, codigo_autorizacao, status)\n" +
                "VALUES (150.75, '2022-05-12 14:30:00', 'Supermercado ABC', '123456789', '987654', 'Aprovada')");

        jdbcTemplate.execute("INSERT INTO transacoes (id,numero_cartao, descricao_id, metodo_de_pagamento_id)\n" +
                "VALUES (23456454545,'1111 2222 3333 4444', 1, 1)");
    }
}
