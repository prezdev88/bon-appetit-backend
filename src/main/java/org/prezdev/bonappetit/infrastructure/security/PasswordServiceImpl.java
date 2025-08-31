package org.prezdev.bonappetit.infrastructure.security;

import org.prezdev.bonappetit.application.security.PasswordService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PasswordServiceImpl implements PasswordService {

    private final PasswordEncoder encoder;

    @Override
    public String hash(String raw) {
        return encoder.encode(raw);
    }

    @Override
    public boolean verify(String raw, String hash) {
        return encoder.matches(raw, hash);
    }

}
