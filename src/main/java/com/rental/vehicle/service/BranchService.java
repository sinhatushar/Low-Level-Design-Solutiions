package com.rental.vehicle.service;

import com.rental.vehicle.model.branch.Branch;
import com.rental.vehicle.model.vehicle.VehicleType;
import com.rental.vehicle.repository.BranchRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class BranchService {

    BranchRepository branchRepository;

    public BranchService() {
        this.branchRepository = new BranchRepository();
    }

    public boolean onboardBranch(String name, List<VehicleType> vehicleTypeList) {

        if(branchRepository.isPresent(name))
            return false;
        else
            return branchRepository.addBranch(new Branch(UUID.randomUUID().toString(), name, vehicleTypeList));
    }
}