CREATE TABLE productos
(
    id                   SERIAL PRIMARY KEY,
    codigo_unico_cliente VARCHAR(255) NOT NULL,
    tipo_producto        VARCHAR(255) NOT NULL,
    nombre               VARCHAR(255) NOT NULL,
    saldo DOUBLE NOT NULL
);

INSERT INTO productos (codigo_unico_cliente, tipo_producto, nombre, saldo)
VALUES ('C001', 'Cuenta de Ahorros', 'Ahorros Dólares', 1500.50),
       ('C002', 'Tarjeta de Crédito', 'MasterCard Gold', 2500.75),
       ('C001', 'Tarjeta de Crédito', 'MasterCard Gold', 4500.75),
       ('C003', 'Cuenta Corriente', 'Corriente Soles', 300.25);
