package com.rental.vehicle.model.account;

import lombok.Getter;
import lombok.NonNull;

@Getter
public abstract class Account {
    private final String id;
    private final String email;

    public Account(@NonNull String id, @NonNull String email) {
        this.id = id;
        this.email = email;
    }
}