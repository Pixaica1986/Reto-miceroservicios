package com.bank.productosservice.service;

import com.bank.productosservice.entity.Producto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoServices {
  Flux<Producto> getProductosByCodigoUnicoCliente(String codigoUnicoCliente);
}
