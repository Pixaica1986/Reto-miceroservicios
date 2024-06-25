package com.bank.backendforfrontend.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
  @Value("${microservices.cliente.config.url}")
  private String clienteServiceUrl;

  @Value("${microservices.producto.config.url}")
  private String productoServiceUrl;

  @Bean
  public WebClient clienteWebClient() {
    return WebClient.builder()
        .baseUrl(clienteServiceUrl)
        .build();
  }

  @Bean
  public WebClient productoWebClient() {
    return WebClient.builder()
        .baseUrl(productoServiceUrl)
        .build();
  }
}
