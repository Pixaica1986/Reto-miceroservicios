package com.bank.backendforfrontend.service.impl;

import com.bank.backendforfrontend.dto.ClienteConProductosDTO;
import com.bank.backendforfrontend.provider.ClienteFeignClient;
import com.bank.backendforfrontend.provider.ProductoFeignClient;
import com.bank.backendforfrontend.service.BFFService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BFFServiceImpl implements BFFService {
  private final ClienteFeignClient clienteFeignClient;
  private final ProductoFeignClient productoFeignClient;

  @Autowired
  public BFFServiceImpl(ClienteFeignClient clienteFeignClient, ProductoFeignClient productoFeignClient) {
    this.clienteFeignClient = clienteFeignClient;
    this.productoFeignClient = productoFeignClient;
  }

  @Override
  public Mono<ClienteConProductosDTO> getClienteConProductos(String codigoUnico) {
    return clienteFeignClient.getCliente(codigoUnico)
        .flatMap(cliente -> productoFeignClient.getProductos(codigoUnico)
            .collectList()
            .map(productos -> new ClienteConProductosDTO(cliente, productos)));
  }
}
