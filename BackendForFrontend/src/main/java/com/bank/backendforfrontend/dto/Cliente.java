package com.bank.backendforfrontend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cliente {
  private Long id;
  private String codigoUnico;
  private String nombres;
  private String apellidos;
  private String tipoDocumento;
  private String numeroDocumento;
}
