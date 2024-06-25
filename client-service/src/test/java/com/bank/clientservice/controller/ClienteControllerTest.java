package com.bank.clientservice.controller;




import static org.mockito.Mockito.when;

import com.bank.clientservice.entity.Cliente;

import com.bank.clientservice.service.ClienteService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class ClienteControllerTest {
  @Mock
  private ClienteService clienteService;

  @InjectMocks
  private ClienteController clienteController;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testGetClienteByCodigoUnicoFound() {
    Cliente cliente = new Cliente();
    cliente.setCodigoUnico("C001");
    cliente.setNombres("Juan");
    cliente.setApellidos("Perez");
    cliente.setTipoDocumento("DNI");
    cliente.setNumeroDocumento("12345678");

    when(clienteService.getClienteByCodigoUnico("C001")).thenReturn(Mono.just(cliente));

    Mono<ResponseEntity<Cliente>> result = clienteController.getCliente("C001");

    StepVerifier.create(result)
        .expectNextMatches(response -> {
          Cliente responseCliente = response.getBody();
          return responseCliente != null &&
              response.getStatusCode() == HttpStatus.OK &&
              responseCliente.getCodigoUnico().equals("C001") &&
              responseCliente.getNombres().equals("Juan") &&
              responseCliente.getApellidos().equals("Perez");
        })
        .verifyComplete();
  }

  @Test
  public void testGetClienteByCodigoUnicoNotFound() {
    when(clienteService.getClienteByCodigoUnico("C002")).thenReturn(Mono.empty());

    Mono<ResponseEntity<Cliente>> result = clienteController.getCliente("C002");

    StepVerifier.create(result)
        .expectNextMatches(response ->
            response.getStatusCode() == HttpStatus.NOT_FOUND &&
                response.getBody() == null)
        .verifyComplete();
  }





}