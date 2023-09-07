package com.rental.vehicle.model.vehicle;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
public abstract class Vehicle {
    private final String id;
    private final VehicleType vehicleType;
    @Setter private double costPerDay;
    @Setter private String associatedBranchId;
    @Setter private VehicleStatus vehicleStatus;

    public Vehicle(@NonNull String id, @NonNull String associatedBranchId, @NonNull double costPerDay,
                           @NonNull VehicleStatus vehicleStatus, @NonNull VehicleType vehicleType) {
        this.id = id;
        this.associatedBranchId = associatedBranchId;
        this.vehicleStatus = vehicleStatus;
        this.vehicleType = vehicleType;
        this.costPerDay = costPerDay;
    }
}