package org.prezdev.bonappetit.application.waiter;

import lombok.RequiredArgsConstructor;

import org.prezdev.bonappetit.application.waiter.dto.WaiterDto;
import org.prezdev.bonappetit.domain.model.identity.AppRole;
import org.prezdev.bonappetit.domain.model.identity.AppUser;
import org.prezdev.bonappetit.domain.repository.AppRoleRepository;
import org.prezdev.bonappetit.domain.repository.AppUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddWaiterService {

    private final AppUserRepository userRepo;
    private final AppRoleRepository roleRepo;

    private static final String WAITER_ROLE = "WAITER";

    @Transactional
    public WaiterDto execute(AddWaiterCommand cmd) {
        if (cmd == null || !StringUtils.hasText(cmd.addWaiterRequest().name())) {
            throw new IllegalArgumentException("name is required");
        }

        if (!StringUtils.hasText(cmd.addWaiterRequest().userIdNumber())) {
            throw new IllegalArgumentException("user id number is required");
        }

        // 1) Buscar rol WAITER (semilla ya insertada en tu script SQL)
        AppRole waiterRole = roleRepo.findByName(WAITER_ROLE)
                .orElseThrow(() -> new IllegalStateException("Role '" + WAITER_ROLE + "' not found"));

        // 2) Crear usuario habilitado con rol WAITER
        AppUser user = AppUser.builder()
                .name(cmd.addWaiterRequest().name().trim())
                .enabled(true)
                .userIdNumber(cmd.addWaiterRequest().userIdNumber().trim())
                .build();
        user.getRoles().add(waiterRole);

        // 3) Persistir
        AppUser saved = userRepo.save(user);

        // 4) Mapear a DTO
        List<String> roles = saved.getRoles().stream().map(AppRole::getName).toList();
        return new WaiterDto(saved.getId(), saved.getName(), saved.isEnabled(), roles);
    }
}
