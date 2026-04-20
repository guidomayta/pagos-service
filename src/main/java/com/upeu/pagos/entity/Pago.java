package com.upeu.pagos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pagos")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_pago", nullable = false, unique = true)
    private String numeroPago;

    @Column(name = "monto", nullable = false)
    private BigDecimal monto;

    @Column(name = "estado", nullable = false)
    private String estado; // PENDIENTE, COMPLETADO, FALLIDO

    @Column(name = "metodo_pago", nullable = false)
    private String metodoPago; // TARJETA, TRANSFERENCIA, EFECTIVO

    @Column(name = "venta_id", nullable = false)
    private Long ventaId;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
        fechaActualizacion = LocalDateTime.now();
        estado = "PENDIENTE";
    }

    @PreUpdate
    protected void onUpdate() {
        fechaActualizacion = LocalDateTime.now();
    }
}
