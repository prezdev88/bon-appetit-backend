package org.prezdev.bonappetit.interfaces.web.waiter;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.prezdev.bonappetit.application.waiter.AddWaiterCommand;
import org.prezdev.bonappetit.application.waiter.AddWaiterService;
import org.prezdev.bonappetit.application.waiter.ListWaitersService;
import org.prezdev.bonappetit.application.waiter.dto.WaiterDto;
import org.prezdev.bonappetit.application.waiter.dto.WaiterListDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/waiters")
@RequiredArgsConstructor
public class WaiterController {

    private final AddWaiterService addWaiter;
    private final ListWaitersService listWaiters;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WaiterDto add(@Valid @RequestBody AddWaiterRequest req) {
        return addWaiter.execute(new AddWaiterCommand(req.name()));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<WaiterListDto> getWaiters() {
        return listWaiters.execute();
    }
    
}
