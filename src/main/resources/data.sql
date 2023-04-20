CREATE TABLE clientes
(
    id             int PRIMARY KEY AUTO_INCREMENT,
    nome           CHAR(50),
    tipo_cliente   CHAR(1),
    limite_credito DOUBLE
);

CREATE TABLE compras (
                            id int PRIMARY KEY AUTO_INCREMENT,
                            cliente_id int,
                            valor double,
                            data_transacao timestamp,
                            compra_quitada boolean,
                            FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

INSERT INTO clientes (nome, tipo_cliente, limite_credito) VALUES ( 'MARIA','A',5000);

                               SELECT * FROM CLIENTES;