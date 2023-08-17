package com.rental.vehicle.model.vehicle;

import lombok.NonNull;

public class Car extends Vehicle {

    public Car(@NonNull String id, @NonNull String associatedBranchId, @NonNull double costPerDay) {
        super(id, associatedBranchId, costPerDay, VehicleStatus.AVAILABLE, VehicleType.CAR);
    }
}
