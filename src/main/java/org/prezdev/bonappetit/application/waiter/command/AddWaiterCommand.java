package org.prezdev.bonappetit.application.waiter.command;

public record AddWaiterCommand(
    String userIdNumber,
    String name
) {}
