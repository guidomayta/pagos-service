package com.upeu.pagos.service;

import com.upeu.pagos.dto.PagoDTO;
import com.upeu.pagos.entity.Pago;
import com.upeu.pagos.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public List<PagoDTO> obtenerTodos() {
        return pagoRepository.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public Optional<PagoDTO> obtenerPorId(Long id) {
        return pagoRepository.findById(id)
                .map(this::convertirADTO);
    }

    public Optional<PagoDTO> obtenerPorNumeroPago(String numeroPago) {
        return pagoRepository.findByNumeroPago(numeroPago)
                .map(this::convertirADTO);
    }

    public List<PagoDTO> obtenerPorVentaId(Long ventaId) {
        return pagoRepository.findByVentaId(ventaId).stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public List<PagoDTO> obtenerPorEstado(String estado) {
        return pagoRepository.findByEstado(estado).stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public PagoDTO crear(PagoDTO pagoDTO) {
        Pago pago = convertirAEntidad(pagoDTO);
        Pago pagGuardado = pagoRepository.save(pago);
        return convertirADTO(pagGuardado);
    }

    public PagoDTO actualizar(Long id, PagoDTO pagoDTO) {
        Optional<Pago> pagoExistente = pagoRepository.findById(id);
        if (pagoExistente.isPresent()) {
            Pago pago = pagoExistente.get();
            pago.setEstado(pagoDTO.getEstado());
            pago.setMetodoPago(pagoDTO.getMetodoPago());
            pago.setMonto(pagoDTO.getMonto());
            Pago pagoActualizado = pagoRepository.save(pago);
            return convertirADTO(pagoActualizado);
        }
        return null;
    }

    public boolean eliminar(Long id) {
        if (pagoRepository.existsById(id)) {
            pagoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private PagoDTO convertirADTO(Pago pago) {
        return new PagoDTO(
                pago.getId(),
                pago.getNumeroPago(),
                pago.getMonto(),
                pago.getEstado(),
                pago.getMetodoPago(),
                pago.getVentaId(),
                pago.getFechaCreacion(),
                pago.getFechaActualizacion()
        );
    }

    private Pago convertirAEntidad(PagoDTO pagoDTO) {
        Pago pago = new Pago();
        pago.setNumeroPago(pagoDTO.getNumeroPago());
        pago.setMonto(pagoDTO.getMonto());
        pago.setEstado(pagoDTO.getEstado() != null ? pagoDTO.getEstado() : "PENDIENTE");
        pago.setMetodoPago(pagoDTO.getMetodoPago());
        pago.setVentaId(pagoDTO.getVentaId());
        return pago;
    }
}
