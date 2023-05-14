CREATE TABLE descricao (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  valor DECIMAL(10,2) NOT NULL,
  data_hora TIMESTAMP NOT NULL,
  estabelecimento VARCHAR(255) NOT NULL,
  nsu VARCHAR(255) NOT NULL,
  codigo_autorizacao VARCHAR(255) NOT NULL,
  status VARCHAR(255) NOT NULL
);

CREATE TABLE metodo_de_pagamento (
 id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  tipo VARCHAR(255) NOT NULL,
  parcelas INTEGER NOT NULL
);



CREATE TABLE transacoes (
  id BIGINT PRIMARY KEY,
  numero_cartao VARCHAR(255) NOT NULL,
  descricao_id BIGINT NOT NULL,
  metodo_de_pagamento_id BIGINT NOT NULL,
  CONSTRAINT fk_descricao FOREIGN KEY (descricao_id) REFERENCES descricao(id),
  CONSTRAINT fk_metodo_de_pagamento FOREIGN KEY (metodo_de_pagamento_id) REFERENCES metodo_de_pagamento(id)
);

