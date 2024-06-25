package com.bank.backendforfrontend.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ClienteConProductosDTO {
  private Cliente cliente;
  private List<Producto> productos;

  public ClienteConProductosDTO(Cliente cliente, List<Producto> productos) {
    this.cliente = cliente;
    this.productos = productos;
  }
}
