package com.bank.clientservice.service.impl;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.bank.clientservice.entity.Cliente;
import com.bank.clientservice.exception.BusinessException;
import com.bank.clientservice.repository.ClienteRepository;
import com.bank.clientservice.util.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class ClienteServiceImplTest {
  @Mock
  private ClienteRepository clienteRepository;

  @InjectMocks
  private ClienteServiceImpl clienteService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }



  @Test
  public void testGetClienteByCodigoUnico() {
    Cliente cliente = new Cliente();
    cliente.setCodigoUnico("C001");
    cliente.setNombres("Juan");
    cliente.setApellidos("Perez");
    cliente.setTipoDocumento("DNI");
    cliente.setNumeroDocumento("12345678");

    when(clienteRepository.findByCodigoUnico(anyString())).thenReturn(Mono.just(cliente));

    Mono<Cliente> result = clienteService.getClienteByCodigoUnico("C001");

    StepVerifier.create(result)
        .expectNext(cliente)
        .verifyComplete();
  }

  @Test
  public void testGetClienteByCodigoUnicoNotFound() {
    when(clienteRepository.findByCodigoUnico(anyString())).thenReturn(Mono.empty());

    Mono<Cliente> result = clienteService.getClienteByCodigoUnico("C002");

    StepVerifier.create(result)
        .expectErrorMatches(throwable -> throwable instanceof BusinessException &&
            Constants.CODE1002.equals(((BusinessException) throwable).getErrorCode()))
        .verify();
  }





}