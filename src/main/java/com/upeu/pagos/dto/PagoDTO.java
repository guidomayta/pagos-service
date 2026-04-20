package com.upeu.pagos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagoDTO {
    private Long id;
    private String numeroPago;
    private BigDecimal monto;
    private String estado;
    private String metodoPago;
    private Long ventaId;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}
