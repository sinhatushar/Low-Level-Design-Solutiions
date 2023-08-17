package com.rental.vehicle.strategies.booking;

import com.rental.vehicle.model.vehicle.Vehicle;

import java.util.List;

public interface BookingStrategy {
    Vehicle select(List<Vehicle> listOfAvailableVehicle);
}