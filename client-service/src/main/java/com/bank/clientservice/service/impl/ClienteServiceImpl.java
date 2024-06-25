package com.bank.clientservice.service.impl;

import com.bank.clientservice.entity.Cliente;
import com.bank.clientservice.exception.BusinessException;
import com.bank.clientservice.repository.ClienteRepository;
import com.bank.clientservice.service.ClienteService;
import com.bank.clientservice.util.Constants;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteServiceImpl implements ClienteService {

  private final ClienteRepository clienteRepository;

  public ClienteServiceImpl(ClienteRepository clienteRepository) {
    this.clienteRepository = clienteRepository;
  }

  @Override
  public Mono<Cliente> getClienteByCodigoUnico(String codigoUnico) {
    if (codigoUnico == null || codigoUnico.isEmpty()) {
      return Mono.error(new BusinessException(Constants.CLIENTE_CODIGO_UNICO_INVALIDO,Constants.CODE1001));
    }
    return clienteRepository.findByCodigoUnico(codigoUnico)
        .switchIfEmpty(Mono.error(new BusinessException(Constants.CLIENTE_NO_ENCONTRADO,Constants.CODE1002)));
  }
}
