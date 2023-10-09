package co.mmg.persona.model.entity;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Builder
public class Cuenta {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "Debe enviar un numero cuenta.")
  @NotBlank(message = "No puede enviar una cuenta vacia.")
  private String numeroCuenta;

  @Min(value = 0,message ="La cuenta no debe ser 0" )
  private BigDecimal saldo;

  private Boolean estado;


}
