package org.prezdev.bonappetit.interfaces.web.waiter;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.prezdev.bonappetit.application.waiter.dto.PageModel;

import org.prezdev.bonappetit.application.waiter.AddWaiterCommand;
import org.prezdev.bonappetit.application.waiter.AddWaiterService;
import org.prezdev.bonappetit.application.waiter.ListWaitersService;
import org.prezdev.bonappetit.application.waiter.dto.WaiterDto;
import org.prezdev.bonappetit.application.waiter.dto.WaiterListDto;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


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
    
}
