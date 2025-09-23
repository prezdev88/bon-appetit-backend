package org.prezdev.bonappetit.application.waiter;

import org.prezdev.bonappetit.application.waiter.dto.EnableWaiterCommand;
import org.prezdev.bonappetit.domain.model.UserRole;
import org.prezdev.bonappetit.domain.repository.AppUserRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnableWaiterService {
    
    private final AppUserRepository userRepo;

    public boolean execute(EnableWaiterCommand cmd) {
        if (cmd == null || cmd.waiterId() == 0) {
            throw new IllegalArgumentException("waiterId is required");
        }

        return userRepo.enableById(cmd.waiterId(), UserRole.WAITER);
    }
}
