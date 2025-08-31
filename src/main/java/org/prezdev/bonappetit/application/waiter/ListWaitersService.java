package org.prezdev.bonappetit.application.waiter;

import java.util.List;

import org.prezdev.bonappetit.application.waiter.dto.WaiterListDto;
import org.prezdev.bonappetit.domain.model.identity.AppUser;
import org.prezdev.bonappetit.domain.repository.AppUserRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListWaitersService {

    private final AppUserRepository userRepo;

    private static final String WAITER_ROLE = "WAITER";

    public List<WaiterListDto> execute() {
        List<AppUser> waitersDb = userRepo.findAllByRoleName(WAITER_ROLE);

        return waitersDb.stream()
                .map(user -> new WaiterListDto(user.getId(), user.getName(), user.isEnabled()))
                .toList();
    }
}
