package org.prezdev.bonappetit.application.waiter;

import org.prezdev.bonappetit.interfaces.web.waiter.AddWaiterRequest;

public record AddWaiterCommand(
    AddWaiterRequest addWaiterRequest
) {}
