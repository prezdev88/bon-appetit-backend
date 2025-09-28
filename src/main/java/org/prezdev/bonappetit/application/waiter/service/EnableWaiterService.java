package org.prezdev.bonappetit.application.waiter.service;

import org.prezdev.bonappetit.application.waiter.command.EnableWaiterCommand;
import org.prezdev.bonappetit.application.waiter.usecase.EnableWaiterUseCase;
import org.prezdev.bonappetit.domain.model.UserRole;
import org.prezdev.bonappetit.domain.repository.AppUserRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnableWaiterService implements EnableWaiterUseCase {
    
    private final AppUserRepository userRepo;

    @Override
    public boolean execute(EnableWaiterCommand cmd) {
        if (cmd == null || cmd.waiterId() == 0) {
            throw new IllegalArgumentException("waiterId is required");
        }

        return userRepo.enableById(cmd.waiterId(), UserRole.WAITER);
    }
}
