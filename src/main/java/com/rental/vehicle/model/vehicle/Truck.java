package com.rental.vehicle.model.vehicle;

import lombok.NonNull;

public class Truck extends Vehicle{

    public Truck(@NonNull String id, @NonNull String associatedBranchId, @NonNull double costPerDay) {
        super(id, associatedBranchId, costPerDay, VehicleStatus.AVAILABLE, VehicleType.TRUCK);
    }
}