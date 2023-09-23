package co.mmg.persona.controller.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponseMessage<T> {
  private int status;
  private String message;
  private T data;
}
