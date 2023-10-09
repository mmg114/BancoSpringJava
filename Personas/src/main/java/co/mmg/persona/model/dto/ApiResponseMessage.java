package co.mmg.persona.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponseMessage<T> {
  private int status;
  private String message;
  private T data;
}
