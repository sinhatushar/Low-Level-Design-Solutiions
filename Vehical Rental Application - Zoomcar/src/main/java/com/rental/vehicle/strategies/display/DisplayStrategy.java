package com.rental.vehicle.strategies.display;

import com.rental.vehicle.model.vehicle.Vehicle;

import java.util.List;

public interface DisplayStrategy {
    void display(List<Vehicle> listOfAvailableVehicle);
}