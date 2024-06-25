package com.bank.productosservice.service.impl;

import com.bank.productosservice.entity.Producto;
import com.bank.productosservice.exception.BusinessException;
import com.bank.productosservice.repository.ProductoRepository;
import com.bank.productosservice.service.ProductoServices;
import com.bank.productosservice.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@Slf4j
public class ProductoServicesImpl implements ProductoServices {

  private final ProductoRepository productoRepository;

  public ProductoServicesImpl(ProductoRepository productoRepository) {
    this.productoRepository = productoRepository;
  }


  @Override
  public Flux<Producto> getProductosByCodigoUnicoCliente(String codigoUnicoCliente) {
    if (codigoUnicoCliente == null || codigoUnicoCliente.isEmpty()) {
      log.info("Invalid codigoUnicoCliente provided: {}", codigoUnicoCliente);
      return Flux.error(new BusinessException(Constants.CLIENTE_CODIGO_UNICO_INVALIDO, Constants.CODE1001));
    }
    log.info("Service: Fetching productos for codigoUnicoCliente: {}", codigoUnicoCliente);
    return productoRepository.findByCodigoUnicoCliente(codigoUnicoCliente)
        .switchIfEmpty(Flux.error(new BusinessException(Constants.CLIENTE_NO_ENCONTRADO, Constants.CODE1002)));
  }

}
