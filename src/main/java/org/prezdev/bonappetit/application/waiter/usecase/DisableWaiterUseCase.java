package org.prezdev.bonappetit.application.waiter.usecase;

import org.prezdev.bonappetit.application.waiter.command.DisableWaiterCommand;

public interface DisableWaiterUseCase {
    boolean execute(DisableWaiterCommand cmd);
}
