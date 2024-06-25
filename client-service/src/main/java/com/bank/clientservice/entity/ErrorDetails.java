package com.bank.clientservice.entity;

public class ErrorDetails {
  private final String message;
  private final String errorCode;

  public ErrorDetails(String message, String errorCode) {
    this.message = message;
    this.errorCode = errorCode;
  }

  public String getMessage() {
    return message;
  }

  public String getErrorCode() {
    return errorCode;
  }
}
