package org.prezdev.bonappetit.application.waiter;

import org.prezdev.bonappetit.domain.model.UserRole;
import org.prezdev.bonappetit.domain.repository.AppUserRepository;
import org.prezdev.bonappetit.interfaces.web.waiter.LoginResponse;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginWaiterService {

    private final AppUserRepository userRepo;

    public LoginResponse login(String userIdNumber) {
        return userRepo.findEnabledUserBy(userIdNumber, UserRole.WAITER)
            .map(user -> new LoginResponse(user.getId(), user.getName()))
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

}
