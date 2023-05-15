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
        //transaction canceled
        jdbcTemplate.execute("INSERT INTO metodo_de_pagamento (tipo, parcelas)\n" +
                "VALUES ('AVISTA', 1)");

        jdbcTemplate.execute("INSERT INTO descricao (valor, data_hora, estabelecimento, nsu, codigo_autorizacao, status)\n" +
                "VALUES (150.75, '2022-05-12 14:30:00', 'Supermercado ABC', '123456789', '254985165', 'CANCELADO')");

        jdbcTemplate.execute("INSERT INTO transacoes (id,numero_cartao, descricao_id, metodo_de_pagamento_id)\n" +
                "VALUES (123465978,'1111 2222 3333 4444', 1, 1)");

        //authorized transaction

        jdbcTemplate.execute("INSERT INTO metodo_de_pagamento (tipo, parcelas)\n" +
                "VALUES ('AVISTA', 1)");

        jdbcTemplate.execute("INSERT INTO descricao (valor, data_hora, estabelecimento, nsu, codigo_autorizacao, status)\n" +
                "VALUES (456.75, '2022-05-13 14:30:00', 'Supermercado Vila Jardim', '254689526', '659854235', 'AUTORIZADO')");

        jdbcTemplate.execute("INSERT INTO transacoes (id,numero_cartao, descricao_id, metodo_de_pagamento_id)\n" +
                "VALUES (658975624,'243567985649', 2, 2)");


        //transaction authorized

        jdbcTemplate.execute("INSERT INTO metodo_de_pagamento (tipo, parcelas)\n" +
                "VALUES ('AVISTA', 1)");

        jdbcTemplate.execute("INSERT INTO descricao (valor, data_hora, estabelecimento, nsu, codigo_autorizacao, status)\n" +
                "VALUES (45000.75, '2022-05-13 09:30:00', 'super car', '565845215', '985648752', 'AUTORIZADO')");

        jdbcTemplate.execute("INSERT INTO transacoes (id,numero_cartao, descricao_id, metodo_de_pagamento_id)\n" +
                "VALUES (526497264,'2546894653612', 3, 3)");
    }
}
