package com.bank.productosservice.service.impl;

import static org.mockito.Mockito.when;

import com.bank.productosservice.entity.Producto;
import com.bank.productosservice.exception.BusinessException;
import com.bank.productosservice.repository.ProductoRepository;
import com.bank.productosservice.util.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class ProductoServicesImplTest {
  @Mock
  private ProductoRepository productoRepository;

  @InjectMocks
  private ProductoServicesImpl productoServices;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testGetProductosByCodigoUnicoCliente_ValidCliente() {
    String codigoUnicoCliente = "C001";

    when(productoRepository.findByCodigoUnicoCliente(codigoUnicoCliente))
        .thenReturn(Flux.empty());

    Flux<Producto> productosFlux = productoServices.getProductosByCodigoUnicoCliente(codigoUnicoCliente);

    StepVerifier.create(productosFlux)
        .expectNextCount(0)
        .expectComplete()
        .verify();
  }

  @Test
  public void testGetProductosByCodigoUnicoCliente_InvalidCliente() {
    String codigoUnicoCliente = "";

    Flux<Producto> productosFlux = productoServices.getProductosByCodigoUnicoCliente(codigoUnicoCliente);
    StepVerifier.create(productosFlux)
        .expectErrorMatches(throwable ->
            throwable instanceof BusinessException &&
                Constants.CLIENTE_CODIGO_UNICO_INVALIDO.equals(((BusinessException) throwable).getMessage()) &&
                Constants.CODE1001.equals(((BusinessException) throwable).getErrorCode()))
        .verify();
  }

}