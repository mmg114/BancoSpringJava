package co.mmg.persona.service;

import co.mmg.persona.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
  Optional<Cuenta> findByNumeroCuenta(String numeroCuenta);

  void deleteByNumeroCuenta(String numeroCuenta);
}
