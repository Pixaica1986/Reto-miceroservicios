package com.bank.backendforfrontend.service;

import com.bank.backendforfrontend.dto.ClienteConProductosDTO;
import reactor.core.publisher.Mono;

public interface BFFService {
  Mono<ClienteConProductosDTO> getClienteConProductos(String codigoUnico);
}
