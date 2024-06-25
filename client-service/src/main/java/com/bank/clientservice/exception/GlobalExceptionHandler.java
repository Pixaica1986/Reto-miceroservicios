package com.bank.clientservice.exception;

import com.bank.clientservice.entity.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(BusinessException.class)
  public Mono<ResponseEntity<ErrorDetails>> handleBusinessException(BusinessException ex) {
    ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), ex.getErrorCode());
    return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails));
  }
}
