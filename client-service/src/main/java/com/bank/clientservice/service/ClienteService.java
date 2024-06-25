package com.bank.clientservice.service;

import com.bank.clientservice.entity.Cliente;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteService {

  Mono<Cliente> getClienteByCodigoUnico(String codigoUnico);



}
