package com.bank.backendforfrontend.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.Decoder;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class FeignConfig {
  @Bean
  public HttpMessageConverters httpMessageConverters(ObjectMapper objectMapper) {
    HttpMessageConverter<Object> jacksonConverter = new MappingJackson2HttpMessageConverter(objectMapper);
    return new HttpMessageConverters(jacksonConverter);
  }
}
