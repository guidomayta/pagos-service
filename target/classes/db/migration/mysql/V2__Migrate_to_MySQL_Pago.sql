-- Migración 2: Alterar tabla PAGO para MySQL (producción)
-- Cambiar tipo de datos y añadir constraints apropiados para MySQL

ALTER TABLE pago 
  MODIFY COLUMN estado VARCHAR(50) NOT NULL DEFAULT 'PENDIENTE',
  MODIFY COLUMN fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  MODIFY COLUMN fecha_actualizacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;

-- Crear índice compuesto para búsquedas comunes
CREATE INDEX IF NOT EXISTS idx_venta_estado ON pago(venta_id, estado);
CREATE INDEX IF NOT EXISTS idx_metodo_fecha ON pago(metodo_pago, fecha_creacion);
