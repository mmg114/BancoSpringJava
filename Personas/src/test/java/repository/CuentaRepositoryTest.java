package repository;

import static org.assertj.core.api.Assertions.assertThat;

import co.mmg.persona.PersonasMain;
import co.mmg.persona.model.Cuenta;
import co.mmg.persona.service.CuentaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;

@Rollback(true)
@SpringBootTest(classes = PersonasMain.class)
public class CuentaRepositoryTest {

  @Autowired private CuentaRepository cuentaRepository;

  @Test
  public void createRepository() {

    Cuenta cuentaEncontrada =
        cuentaRepository.save(
            Cuenta.builder().numeroCuenta("123123123").estado(true).saldo(BigDecimal.ZERO).build());

    assertThat(cuentaEncontrada.getNumeroCuenta()).isEqualTo("123123123");
  }
}
