package com.bank.backendforfrontend.configuration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncryptionService {
  private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  public String encrypt(String codigoUnico) {
    return passwordEncoder.encode(codigoUnico);
  }

  public boolean matches(String rawCodigoUnico, String encryptedCodigoUnico) {
    return passwordEncoder.matches(rawCodigoUnico, encryptedCodigoUnico);
  }
}
