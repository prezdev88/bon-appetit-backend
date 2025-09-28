package org.prezdev.bonappetit.application.waiter.service;

import org.prezdev.bonappetit.application.waiter.command.DisableWaiterCommand;
import org.prezdev.bonappetit.domain.model.UserRole;
import org.prezdev.bonappetit.domain.repository.AppUserRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DisableWaiterService {

    private final AppUserRepository userRepo;

    public boolean execute(DisableWaiterCommand cmd) {
        if (cmd == null || cmd.waiterId() == 0) {
            throw new IllegalArgumentException("waiterId is required");
        }

        return userRepo.disableById(cmd.waiterId(), UserRole.WAITER);
    }
}
