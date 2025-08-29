package org.prezdev.bonappetit.interfaces.web.waiter;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.prezdev.bonappetit.application.waiter.AddWaiterCommand;
import org.prezdev.bonappetit.application.waiter.AddWaiterService;
import org.prezdev.bonappetit.application.waiter.WaiterDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/waiters")
@RequiredArgsConstructor
public class WaiterController {

    private final AddWaiterService addWaiter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WaiterDto add(@Valid @RequestBody AddWaiterRequest req) {
        return addWaiter.execute(new AddWaiterCommand(req.name()));
    }
}
