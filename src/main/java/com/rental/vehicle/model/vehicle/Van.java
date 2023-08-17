package com.rental.vehicle.model.vehicle;

import lombok.NonNull;

public class Van extends Vehicle{

    public Van(@NonNull String id, @NonNull String associatedBranchId, @NonNull double costPerDay) {
        super(id, associatedBranchId, costPerDay, VehicleStatus.AVAILABLE, VehicleType.VAN);
    }
}
