package com.rental.vehicle.strategies.display;

import com.rental.vehicle.model.vehicle.Vehicle;

import java.util.Comparator;
import java.util.List;

public class SortedByPriceStrategy implements DisplayStrategy {

    @Override
    public void display(List<Vehicle> listOfAvailableVehicle) {
        listOfAvailableVehicle.sort(Comparator.comparingDouble(Vehicle::getCostPerDay));

        boolean isFirst = true;
        for (Vehicle vehicle : listOfAvailableVehicle) {
            if (isFirst) {
                System.out.print(vehicle.getId());        // no comma
                isFirst = false;
            } else {
                System.out.print(", " + vehicle.getId());   // comma
            }
        }
    }
}