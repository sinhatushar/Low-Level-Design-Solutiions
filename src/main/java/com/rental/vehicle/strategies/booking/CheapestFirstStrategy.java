package com.rental.vehicle.strategies.booking;

import com.rental.vehicle.model.vehicle.Vehicle;

import java.util.Comparator;
import java.util.List;

public class CheapestFirstStrategy implements BookingStrategy{

    @Override
    public Vehicle select(List<Vehicle> listOfAvailableVehicle) {
        if(listOfAvailableVehicle.isEmpty())
            return null;

        listOfAvailableVehicle.sort(Comparator.comparingDouble(Vehicle::getCostPerDay));
        return listOfAvailableVehicle.get(0);
    }
}