package org.prezdev.bonappetit.application.waiter.usecase;

import org.prezdev.bonappetit.application.waiter.command.EnableWaiterCommand;

public interface EnableWaiterUseCase {
    boolean execute(EnableWaiterCommand cmd);
}
