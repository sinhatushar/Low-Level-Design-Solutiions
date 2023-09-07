package com.rental.vehicle.service;

import com.rental.vehicle.model.branch.Branch;
import com.rental.vehicle.model.vehicle.Vehicle;
import com.rental.vehicle.repository.BranchRepository;
import com.rental.vehicle.strategies.display.DisplayStrategy;
import com.rental.vehicle.strategies.display.SortedByPriceStrategy;
import com.rental.vehicle.strategies.search.SearchByBranchStrategy;
import com.rental.vehicle.strategies.search.SearchStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class DisplayService {

    public void display(String branchName, int startDay, int endDay){

        BranchRepository branchRepository = new BranchRepository();
        Optional<Branch> branch = branchRepository.getBranchByName(branchName);
        if(branch.isEmpty()) {
//            System.out.println("No vehicles as per display criteria");
            return;
        }

        // Search for all available vehicles in this branch
        SearchStrategy searchStrategy = new SearchByBranchStrategy(branch.get(), startDay, endDay);
        List<Vehicle> availableVehicles = searchStrategy.search();

        // Display the vehicles in sorted order of the price
        DisplayStrategy displayStrategy = new SortedByPriceStrategy();
        displayStrategy.display(availableVehicles);
    }
}