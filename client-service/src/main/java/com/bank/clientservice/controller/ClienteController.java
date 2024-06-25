package com.bank.clientservice.controller;

import com.bank.clientservice.entity.Cliente;
import com.bank.clientservice.entity.ErrorDetails;
import com.bank.clientservice.exception.BusinessException;
import com.bank.clientservice.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/app/v1/clientes")
public class ClienteController {

  private final ClienteService clienteService;

  public ClienteController(ClienteService clienteService) {
    this.clienteService = clienteService;
  }


  @GetMapping("/{codigoUnico}")
  public Mono<ResponseEntity<Cliente>> getCliente(@PathVariable String codigoUnico) {
    return clienteService.getClienteByCodigoUnico(codigoUnico)
        .map(cliente -> ResponseEntity.ok(cliente))
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ErrorDetails> handleBusinessException(BusinessException ex) {
    ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), ex.getErrorCode());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
  }


}
