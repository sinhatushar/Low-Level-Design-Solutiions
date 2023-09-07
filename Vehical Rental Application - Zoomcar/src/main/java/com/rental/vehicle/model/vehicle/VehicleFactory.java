package com.rental.vehicle.model.vehicle;

import lombok.NonNull;

public class VehicleFactory {

    public static Vehicle getVehicle(@NonNull String branchId, @NonNull VehicleType vehicleType,
                                             @NonNull String vehicleId, @NonNull double costPerDay) {
        switch (vehicleType) {
            case BICYCLE:
                return new Bicycle(vehicleId, branchId, costPerDay);
            case BIKE:
                return new Bike(vehicleId, branchId, costPerDay);
            case BUS:
                return new Bus(vehicleId, branchId, costPerDay);
            case CAR:
                return new Car(vehicleId, branchId, costPerDay);
            case TRUCK:
                return new Truck(vehicleId, branchId, costPerDay);
            case VAN:
                return new Van(vehicleId, branchId, costPerDay);
            default:
                return null;
        }
    }
}