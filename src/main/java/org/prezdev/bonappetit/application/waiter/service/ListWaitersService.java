package org.prezdev.bonappetit.application.waiter.service;

import java.util.List;

import org.prezdev.bonappetit.application.waiter.response.PageModel;
import org.prezdev.bonappetit.application.waiter.response.WaiterListDto;
import org.prezdev.bonappetit.domain.model.AppUser;
import org.prezdev.bonappetit.domain.repository.AppUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListWaitersService {

    private final AppUserRepository userRepo;

    private static final String WAITER_ROLE = "WAITER";

    public PageModel<WaiterListDto> execute(int page, int size, Sort sort) {
        Page<AppUser> waitersDb = userRepo.findAllByRoleName(WAITER_ROLE, page, size, sort);
        
        List<WaiterListDto> content = waitersDb.getContent().stream()
            .map(user -> new WaiterListDto(user.getId(), user.getName(), user.isEnabled()))
            .toList();

        return new PageModel<>(
            content,
            waitersDb.getNumber(),
            waitersDb.getSize(),
            waitersDb.getTotalElements(),
            waitersDb.getTotalPages(),
            waitersDb.isLast()
        );
    }
}
