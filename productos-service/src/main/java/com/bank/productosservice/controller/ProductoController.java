package com.bank.productosservice.controller;

import com.bank.productosservice.entity.ErrorDetails;
import com.bank.productosservice.entity.Producto;
import com.bank.productosservice.exception.BusinessException;
import com.bank.productosservice.service.ProductoServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/app/v1/productos")
@Slf4j
public class ProductoController {


  private final ProductoServices productoServices;

  public ProductoController(ProductoServices productoServices) {
    this.productoServices = productoServices;
  }

  @GetMapping("/{codigoUnicoCliente}")
  public Flux<Producto> getProductos(@PathVariable String codigoUnicoCliente) {
    log.info("Controller: Fetching productos for codigoUnicoCliente: {}",codigoUnicoCliente );
    return productoServices.getProductosByCodigoUnicoCliente(codigoUnicoCliente);
  }

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ErrorDetails> handleBusinessException(BusinessException ex) {
    ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), ex.getErrorCode());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
  }
}
