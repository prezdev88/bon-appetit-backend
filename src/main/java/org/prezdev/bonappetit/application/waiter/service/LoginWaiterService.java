package org.prezdev.bonappetit.application.waiter.service;

import org.prezdev.bonappetit.application.waiter.response.LoginResponse;
import org.prezdev.bonappetit.application.waiter.usecase.LoginWaiterUserCase;
import org.prezdev.bonappetit.domain.model.UserRole;
import org.prezdev.bonappetit.domain.repository.AppUserRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginWaiterService implements LoginWaiterUserCase {

    private final AppUserRepository userRepo;

    @Override
    public LoginResponse login(String userIdNumber) {
        return userRepo.findEnabledUserBy(userIdNumber, UserRole.WAITER)
            .map(user -> new LoginResponse(user.getId(), user.getName()))
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

}
