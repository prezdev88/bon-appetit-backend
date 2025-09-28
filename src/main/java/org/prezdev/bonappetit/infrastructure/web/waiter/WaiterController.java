package org.prezdev.bonappetit.infrastructure.web.waiter;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.prezdev.bonappetit.application.waiter.command.AddWaiterCommand;
import org.prezdev.bonappetit.application.waiter.command.DisableWaiterCommand;
import org.prezdev.bonappetit.application.waiter.command.EnableWaiterCommand;
import org.prezdev.bonappetit.application.waiter.response.AddWaiterResponse;
import org.prezdev.bonappetit.application.waiter.response.LoginResponse;
import org.prezdev.bonappetit.application.waiter.response.PageModel;
import org.prezdev.bonappetit.application.waiter.response.WaiterListDto;
import org.prezdev.bonappetit.application.waiter.service.AddWaiterService;
import org.prezdev.bonappetit.application.waiter.service.DisableWaiterService;
import org.prezdev.bonappetit.application.waiter.service.EnableWaiterService;
import org.prezdev.bonappetit.application.waiter.service.ListWaitersService;
import org.prezdev.bonappetit.application.waiter.service.LoginWaiterService;
import org.prezdev.bonappetit.application.waiter.service.SearchWaiterService;
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
    private final DisableWaiterService disableWaiter;
    private final EnableWaiterService enableWaiter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddWaiterResponse add(@Valid @RequestBody AddWaiterRequest req) {
        return addWaiter.execute(new AddWaiterCommand(req.userIdNumber(), req.name()));
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

    @DeleteMapping("/{waiterId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void disableWaiter(@PathVariable long waiterId) {
        boolean disabled = disableWaiter.execute(new DisableWaiterCommand(waiterId));
        if (!disabled) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Waiter not found or already disabled");
        }
    }

    // curl -X PATCH http://localhost:8080/api/waiters/1/enable
    @PatchMapping("/{waiterId}/enable")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void enableWaiter(@PathVariable long waiterId) {
        boolean enabled = enableWaiter.execute(new EnableWaiterCommand(waiterId));
        if (!enabled) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Waiter not found or already enabled");
        }
    }
}
