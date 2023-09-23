package co.mmg.persona.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Transferencia {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "cuenta_origen_id")
  private Cuenta cuentaOrigen;

  @ManyToOne
  @JoinColumn(name = "cuenta_destino_id")
  private Cuenta cuentaDestino;

  private BigDecimal monto;

  private LocalDateTime fechaTransferencia;

  private Boolean estado;
}
