package com.bank.backendforfrontend.provider;

import com.bank.backendforfrontend.dto.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;


@FeignClient(name = "producto-service", url = "${microservices.producto.config.url}")
public interface ProductoFeignClient {

  @GetMapping(value = "${microservices.producto.service.url}")
  Flux<Producto> getProductos(@PathVariable("codigoUnicoCliente") String codigoUnicoCliente);
}
