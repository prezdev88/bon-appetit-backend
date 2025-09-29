package org.prezdev.bonappetit.application.waiter.usecase;

import org.prezdev.bonappetit.application.waiter.response.LoginResponse;

public interface LoginWaiterUseCase {
    LoginResponse login(String userIdNumber);
}
