-- Migración 1: Crear tabla PAGO
CREATE TABLE pago (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    numero_pago VARCHAR(50) NOT NULL UNIQUE,
    monto DECIMAL(10, 2) NOT NULL,
    estado VARCHAR(50) NOT NULL DEFAULT 'PENDIENTE',
    metodo_pago VARCHAR(50) NOT NULL,
    venta_id BIGINT NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Crear índices
CREATE INDEX idx_numero_pago ON pago(numero_pago);
CREATE INDEX idx_estado ON pago(estado);
CREATE INDEX idx_venta_id ON pago(venta_id);
CREATE INDEX idx_metodo_pago ON pago(metodo_pago);
