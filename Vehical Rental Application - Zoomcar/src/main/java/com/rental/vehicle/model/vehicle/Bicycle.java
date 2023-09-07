package com.rental.vehicle.model.vehicle;

import lombok.NonNull;

public class Bicycle extends Vehicle{

    public Bicycle(@NonNull String id, @NonNull String associatedBranchId, @NonNull double costPerDay) {
        super(id, associatedBranchId, costPerDay, VehicleStatus.AVAILABLE, VehicleType.BICYCLE);
    }
}