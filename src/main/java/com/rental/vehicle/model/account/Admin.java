package com.rental.vehicle.model.account;

import lombok.NonNull;

public class Admin extends Account{

    public Admin(@NonNull String id, @NonNull String email) {
        super(id, email);
    }
}