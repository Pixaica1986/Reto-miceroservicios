package com.bank.clientservice.repository;

import com.bank.clientservice.entity.Cliente;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ClienteRepository extends ReactiveCrudRepository<Cliente, Long> {
  Mono<Cliente> findByCodigoUnico(String codigoUnico);
}
