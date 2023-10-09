package co.mmg.persona.model.repository;

import co.mmg.persona.model.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
  Optional<Cuenta> findByNumeroCuenta(String numeroCuenta);

  void deleteByNumeroCuenta(String numeroCuenta);
}
