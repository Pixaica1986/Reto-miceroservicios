package com.bank.backendforfrontend.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import reactor.core.publisher.Mono;

@Configuration
public class JacksonConfig {
  @Bean
  public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
    ObjectMapper objectMapper = builder.createXmlMapper(false).build();
    SimpleModule module = new SimpleModule();
    module.addSerializer(Mono.class, ToStringSerializer.instance); // Serializa Mono a su representación como String
    objectMapper.registerModule(module);
    return objectMapper;
  }
}
