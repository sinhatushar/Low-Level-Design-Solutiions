package com.rental.vehicle.strategies.dynamic.pricing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PercentChargeStrategy implements DynamicPricingStrategy{

    double percent, fixedCost;

    @Override
    public double getDynamicPriceCost() {
        fixedCost += fixedCost*(percent/100d);
        return fixedCost;
    }
}