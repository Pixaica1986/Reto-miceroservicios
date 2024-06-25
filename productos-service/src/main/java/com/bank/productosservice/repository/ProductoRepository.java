package com.bank.productosservice.repository;

import com.bank.productosservice.entity.Producto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductoRepository extends ReactiveCrudRepository<Producto, Long> {
  Flux<Producto> findByCodigoUnicoCliente(String codigoUnicoCliente);
}
