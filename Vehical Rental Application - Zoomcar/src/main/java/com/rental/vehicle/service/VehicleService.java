package com.rental.vehicle.service;

import com.rental.vehicle.model.branch.Branch;
import com.rental.vehicle.model.vehicle.Vehicle;
import com.rental.vehicle.model.vehicle.VehicleFactory;
import com.rental.vehicle.model.vehicle.VehicleType;
import com.rental.vehicle.repository.BranchRepository;
import com.rental.vehicle.repository.VehicleRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class VehicleService {

    VehicleRepository vehicleRepository = new VehicleRepository();
    BranchRepository branchRepository = new BranchRepository();

    public Vehicle getVehicleById(String id) {
        return vehicleRepository.getVehicle(id);
    }

    public boolean onboardVehicle(String branchName, VehicleType vehicleType, String vehicleId, double costPerDay) {
        Optional<Branch> rBranch = branchRepository.getBranchByName(branchName);
        if(rBranch.isPresent() && rBranch
                                        .get()
                                        .getAvailableVehicleTypesList()
                                        .stream()
                                        .anyMatch(vehicleType1 -> vehicleType == vehicleType1))
        {
            String branchId = rBranch.get().getBranchId();

            Vehicle newVehicle = VehicleFactory.getVehicle(branchId, vehicleType, vehicleId, costPerDay);
            branchRepository.addVehicleToBranch(branchId, newVehicle);    //Adding vehicle to branch

            return vehicleRepository.addVehicle(newVehicle);    //Adding vehicle to branch repository
        }
        else
            return false;
    }
}