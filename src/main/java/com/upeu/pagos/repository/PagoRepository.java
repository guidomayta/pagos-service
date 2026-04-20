package com.upeu.pagos.repository;

import com.upeu.pagos.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
    Optional<Pago> findByNumeroPago(String numeroPago);
    List<Pago> findByVentaId(Long ventaId);
    List<Pago> findByEstado(String estado);
}
