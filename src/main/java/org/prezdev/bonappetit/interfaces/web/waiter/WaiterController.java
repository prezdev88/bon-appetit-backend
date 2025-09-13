package org.prezdev.bonappetit.interfaces.web.waiter;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.prezdev.bonappetit.application.waiter.dto.PageModel;

import org.prezdev.bonappetit.application.waiter.AddWaiterCommand;
import org.prezdev.bonappetit.application.waiter.AddWaiterService;
import org.prezdev.bonappetit.application.waiter.ListWaitersService;
import org.prezdev.bonappetit.application.waiter.LoginWaiterService;
import org.prezdev.bonappetit.application.waiter.SearchWaiterService;
import org.prezdev.bonappetit.application.waiter.dto.WaiterDto;
import org.prezdev.bonappetit.application.waiter.dto.WaiterListDto;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api/waiters")
@RequiredArgsConstructor
public class WaiterController {

    private final AddWaiterService addWaiter;
    private final ListWaitersService listWaiters;
    private final LoginWaiterService login;
    private final SearchWaiterService searchWaiter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WaiterDto add(@Valid @RequestBody AddWaiterRequest req) {
        return addWaiter.execute(new AddWaiterCommand(req));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PageModel<WaiterListDto> getWaiters(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "20") int size,
        @RequestParam(defaultValue = "id,asc") String[] sort
    ) {
        Sort sortObject = Sort.by(new Sort.Order(
            Sort.Direction.fromString(sort[1]), sort[0]
        ));

        return listWaiters.execute(page, size, sortObject);
    }
    
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@Valid @RequestBody LoginRequest req) {
        try {
            return login.login(req.userIdNumber());
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
    
    @GetMapping("/search")
    public PageModel<WaiterListDto> searchWaiter(
        @RequestParam("name") String name,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "20") int size,
        @RequestParam(defaultValue = "id,asc") String[] sort
    ) {
        Sort sortObject = Sort.by(new Sort.Order(
            Sort.Direction.fromString(sort[1]), sort[0]
        ));

        return searchWaiter.execute(name, page, size, sortObject);
    }
    
}
