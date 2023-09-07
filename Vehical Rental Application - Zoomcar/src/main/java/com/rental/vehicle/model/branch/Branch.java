package com.rental.vehicle.model.branch;

import com.rental.vehicle.model.vehicle.Vehicle;
import com.rental.vehicle.model.vehicle.VehicleType;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Branch {
    private final String branchId;
    private final String name;
    private final List<VehicleType> availableVehicleTypesList;
    private final List<Vehicle> vehiclesList;

    public Branch(String branchId, String name, List<VehicleType> availableVehicleTypesList) {
        this.branchId = branchId;
        this.name = name;
        this.availableVehicleTypesList = availableVehicleTypesList;
        vehiclesList = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle){
        vehiclesList.add(vehicle);
    }
}