package com.rental.vehicle.strategies.search;

import com.rental.vehicle.model.vehicle.Vehicle;

import java.util.List;

public interface SearchStrategy {
    List<Vehicle> search();
}