package com.bank.clientservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("clientes")
public class Cliente {
  @Id
  private Long id;
  private String codigoUnico;
  private String nombres;
  private String apellidos;
  private String tipoDocumento;
  private String numeroDocumento;
}
