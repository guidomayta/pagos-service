package com.upeu.pagos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ventas")
public interface VentaFeignClient {

    @GetMapping("/api/ventas")
    Object getAllVentas();

    @GetMapping("/api/ventas/{id}")
    Object getVenta(@PathVariable("id") Long id);

    @GetMapping("/api/ventas/numero/{numeroVenta}")
    Object getVentaByNumero(@PathVariable("numeroVenta") String numeroVenta);
}
