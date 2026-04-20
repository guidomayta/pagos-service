package com.upeu.pagos.controller;

import com.upeu.pagos.dto.PagoDTO;
import com.upeu.pagos.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pagos")
@CrossOrigin(origins = "*")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping
    public ResponseEntity<List<PagoDTO>> obtenerTodos() {
        return ResponseEntity.ok(pagoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoDTO> obtenerPorId(@PathVariable Long id) {
        Optional<PagoDTO> pago = pagoService.obtenerPorId(id);
        return pago.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/numero/{numeroPago}")
    public ResponseEntity<PagoDTO> obtenerPorNumeroPago(@PathVariable String numeroPago) {
        Optional<PagoDTO> pago = pagoService.obtenerPorNumeroPago(numeroPago);
        return pago.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/venta/{ventaId}")
    public ResponseEntity<List<PagoDTO>> obtenerPorVentaId(@PathVariable Long ventaId) {
        return ResponseEntity.ok(pagoService.obtenerPorVentaId(ventaId));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<PagoDTO>> obtenerPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(pagoService.obtenerPorEstado(estado));
    }

    @PostMapping
    public ResponseEntity<PagoDTO> crear(@RequestBody PagoDTO pagoDTO) {
        PagoDTO pagoCreado = pagoService.crear(pagoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pagoCreado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagoDTO> actualizar(@PathVariable Long id, @RequestBody PagoDTO pagoDTO) {
        PagoDTO pagoActualizado = pagoService.actualizar(id, pagoDTO);
        if (pagoActualizado != null) {
            return ResponseEntity.ok(pagoActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (pagoService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
