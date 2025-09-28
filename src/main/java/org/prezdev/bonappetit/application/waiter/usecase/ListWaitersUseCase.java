package org.prezdev.bonappetit.application.waiter.usecase;

import org.prezdev.bonappetit.application.waiter.response.PageModel;
import org.prezdev.bonappetit.application.waiter.response.WaiterListDto;
import org.springframework.data.domain.Sort;

public interface ListWaitersUseCase {
    PageModel<WaiterListDto> execute(int page, int size, Sort sort);
}
