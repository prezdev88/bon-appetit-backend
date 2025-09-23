package org.prezdev.bonappetit.application.waiter.dto;

import org.prezdev.bonappetit.interfaces.web.waiter.AddWaiterRequest;

public record AddWaiterCommand(
    AddWaiterRequest addWaiterRequest
) {}
