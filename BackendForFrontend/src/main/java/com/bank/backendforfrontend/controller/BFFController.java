package com.bank.backendforfrontend.controller;

import com.bank.backendforfrontend.dto.ClienteConProductosDTO;
import com.bank.backendforfrontend.service.BFFService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/app/v1/bff")
@RequiredArgsConstructor
public class BFFController {
  private final BFFService bffService;

  @GetMapping("/{codigoUnico}")
  public Mono<ClienteConProductosDTO> getClienteConProductos(@PathVariable String codigoUnico) {
    return bffService.getClienteConProductos(codigoUnico);
  }
}
