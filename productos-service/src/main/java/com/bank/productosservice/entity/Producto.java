package com.bank.productosservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("productos")
public class Producto {
  @Id
  private Long id;
  private String codigoUnicoCliente;
  private String tipoProducto;
  private String nombre;
  private BigDecimal saldo;
}
