package com.rental.vehicle.model.vehicle;

import lombok.NonNull;

public class Bus extends Vehicle{

    public Bus(@NonNull String id, @NonNull String associatedBranchId, @NonNull double costPerDay) {
        super(id, associatedBranchId, costPerDay, VehicleStatus.AVAILABLE, VehicleType.BUS);
    }
}
