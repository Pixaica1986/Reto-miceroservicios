package com.bank.backendforfrontend.provider;

import com.bank.backendforfrontend.dto.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

@FeignClient(name = "client-service", url = "${microservices.cliente.config.url}")
public interface ClienteFeignClient {

  @GetMapping(value = "${microservices.cliente.service.url}")
  Mono<Cliente> getCliente(@PathVariable("codigoUnico") String codigoUnico);
}
