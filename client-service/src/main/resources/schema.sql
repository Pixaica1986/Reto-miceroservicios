CREATE TABLE clientes
(
    id               SERIAL PRIMARY KEY,
    codigo_unico     VARCHAR(255) NOT NULL,
    nombres          VARCHAR(255) NOT NULL,
    apellidos        VARCHAR(255) NOT NULL,
    tipo_documento   VARCHAR(50)  NOT NULL,
    numero_documento VARCHAR(50)  NOT NULL
);

-- Insertar datos de ejemplo
INSERT INTO clientes (codigo_unico, nombres, apellidos, tipo_documento, numero_documento)
VALUES ('C001', 'Juan', 'Perez', 'DNI', '12345678'),
       ('C002', 'Maria', 'Gomez', 'DNI', '87654321'),
       ('C003', 'Luis', 'Pottozen', 'DNI', '48893957'),
       ('C004', 'Ana', 'Lopez', 'DNI', '44332211');
