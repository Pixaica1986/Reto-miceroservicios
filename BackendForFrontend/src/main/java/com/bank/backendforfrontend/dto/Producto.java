package com.bank.backendforfrontend.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Producto {
  private String codigoUnicoCliente;
  private String tipoProducto;
  private String nombre;
  private BigDecimal saldo;
}
