package com.rental.vehicle.strategies.pricing;

import com.rental.vehicle.model.vehicle.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SameCostForEveryDayStrategy implements PricingStrategy{

    private int startTime, endTime;
    Vehicle vehicle;

    @Override
    public double calculateCost() {
        double perDayCost = vehicle.getCostPerDay();
        double totalCost  = perDayCost*(endTime-startTime);
        return totalCost;
    }
}