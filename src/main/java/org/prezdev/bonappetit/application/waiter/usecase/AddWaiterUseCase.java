package org.prezdev.bonappetit.application.waiter.usecase;

import org.prezdev.bonappetit.application.waiter.command.AddWaiterCommand;
import org.prezdev.bonappetit.application.waiter.response.AddWaiterResponse;

public interface AddWaiterUseCase {
    AddWaiterResponse execute(AddWaiterCommand cmd);
}
