package com.rental.vehicle.repository;

import com.rental.vehicle.exceptions.InvalidIdException;
import com.rental.vehicle.model.vehicle.Vehicle;
import com.rental.vehicle.model.vehicle.VehicleStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleRepository {

    public static Map<String, Vehicle> vehicleMap = new HashMap<>();
    public static List<Vehicle> vehicles = new ArrayList<>();

    public Vehicle getVehicle(String vehicleId) throws InvalidIdException{
        Vehicle vehicle = vehicleMap.get(vehicleId);
        if(vehicle == null)
            throw new InvalidIdException("Vehicle Id is invalid");

        return vehicle;
    }

    public List<Vehicle> getAll() {
        return vehicles;
    }

    public boolean addVehicle(Vehicle vehicle) {
        Vehicle oldVehicle = vehicleMap.putIfAbsent(vehicle.getId(), vehicle);
        if (oldVehicle != null)
            return false;

        vehicles.add(vehicle);
        return true;
    }

    public void removeVehicle(String vehicleId) throws InvalidIdException{
        Vehicle vehicle = vehicleMap.remove(vehicleId);
        if(vehicle == null)
            throw new InvalidIdException("Vehicle Id is invalid");

        for (Vehicle iVehicle : vehicles) {
            if (iVehicle.getId().equals(vehicleId)) {
                vehicles.remove(iVehicle);
                break;
            }
        }
    }

    public Vehicle updateStatus(String vehicleId, VehicleStatus vehicleStatus){
        Vehicle vehicle = getVehicle(vehicleId);
        vehicle.setVehicleStatus(vehicleStatus);

        return vehicle;
    }
}