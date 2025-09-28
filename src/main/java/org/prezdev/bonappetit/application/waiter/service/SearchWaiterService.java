package org.prezdev.bonappetit.application.waiter.service;

import java.util.List;

import org.prezdev.bonappetit.application.waiter.response.PageModel;
import org.prezdev.bonappetit.application.waiter.response.WaiterListDto;
import org.prezdev.bonappetit.application.waiter.util.AccentNormalizer;
import org.prezdev.bonappetit.domain.model.AppUser;
import org.prezdev.bonappetit.domain.repository.AppUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SearchWaiterService {

    private final AppUserRepository userRepo;
    private final AccentNormalizer accentNormalizer;

    public PageModel<WaiterListDto> execute(String name, int page, int size, Sort sort) {
        String normalizedName = accentNormalizer.normalize(name);
        Page<AppUser> waitersDb = userRepo.findAllByName(normalizedName, page, size, sort);

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
