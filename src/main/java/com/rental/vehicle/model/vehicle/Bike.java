package com.rental.vehicle.model.vehicle;

import lombok.NonNull;

public class Bike extends Vehicle{

    public Bike(@NonNull String id, @NonNull String associatedBranchId, @NonNull double costPerDay) {
        super(id, associatedBranchId, costPerDay, VehicleStatus.AVAILABLE, VehicleType.BIKE);
    }
}
