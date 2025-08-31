package org.prezdev.bonappetit.application.security;

public interface PasswordService {
    String hash(String raw);
    
    boolean verify(String raw, String hash);
}
