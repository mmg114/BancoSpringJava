package co.mmg.persona.model.service.imp;

import co.mmg.persona.model.entity.Cuenta;
import co.mmg.persona.model.repository.CuentaRepository;
import co.mmg.persona.model.service.ICuentaService;
import jakarta.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CuentaService implements ICuentaService {

  @Autowired CuentaRepository cuentaRepository;

  public Cuenta save(@Valid Cuenta cuenta) throws Exception {
    Optional<Cuenta> cuentaExistente =
        cuentaRepository.findByNumeroCuenta(cuenta.getNumeroCuenta());

    if (cuentaExistente.isPresent()) {
      throw new Exception("Ya existe una cuenta con el mismo número de cuenta."+ cuenta.getNumeroCuenta());
    }

    if (!StringUtils.isNumeric(cuenta.getNumeroCuenta())) {
      throw new Exception("La cuenta debe ser numerica.");
    }

    if (cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0) {
      throw new Exception("El saldo no puede ser negativo.");
    }
    return cuentaRepository.save(cuenta);
  }

  public Cuenta update(Cuenta cuenta) throws Exception {
    Optional<Cuenta> cuentaExistente =
        cuentaRepository.findByNumeroCuenta(cuenta.getNumeroCuenta());
    if (cuentaExistente.isPresent()) {
      Cuenta actualizarCUenta = cuentaExistente.get();
      actualizarCUenta.setSaldo(cuenta.getSaldo());
      return cuentaRepository.save(cuenta);
    } else {

      throw new Exception("NO existe una cuenta Con ese numero.");
    }
  }

  @Transactional()
  public void delete(String numeroDeCuenta) throws Exception {
    Optional<Cuenta> cuentaExistente = cuentaRepository.findByNumeroCuenta(numeroDeCuenta);
    if (!cuentaExistente.isPresent()) {
      throw new Exception("No existe una cuenta con el mismo número de cuenta.");
    }
    if (cuentaExistente.get().getSaldo().compareTo(BigDecimal.ZERO) < 0) {
      throw new Exception(
          "Aun No ha normalizado sus Obligaciones. saldo:" + cuentaExistente.get().getSaldo());
    }

    cuentaRepository.deleteByNumeroCuenta(numeroDeCuenta);
  }

  @Transactional(readOnly = true)
  public Cuenta findByNumberCount(String count) throws Exception {
    return cuentaRepository.findByNumeroCuenta(count).get();
  }

  @Transactional(readOnly = true)
  public List<Cuenta> findByAll() throws Exception {
    return cuentaRepository.findAll();
  }
}
