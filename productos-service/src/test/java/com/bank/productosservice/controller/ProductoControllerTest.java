package com.bank.productosservice.controller;

import static org.mockito.Mockito.when;

import com.bank.productosservice.entity.Producto;
import com.bank.productosservice.service.ProductoServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class ProductoControllerTest {

  @Mock
  private ProductoServices productoServices;


  @InjectMocks
  private ProductoController controller;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testGetProductos() {
    String codigoUnicoCliente = "C001";

    when(productoServices.getProductosByCodigoUnicoCliente(codigoUnicoCliente))
        .thenReturn(Flux.empty());

    // Llamar al método del controlador
    Flux<Producto> productosFlux = controller.getProductos(codigoUnicoCliente);


    // Verificar el flujo usando StepVerifier
    StepVerifier.create(productosFlux)
        .expectNextCount(0)
        .expectComplete()
        .verify();
  }

}