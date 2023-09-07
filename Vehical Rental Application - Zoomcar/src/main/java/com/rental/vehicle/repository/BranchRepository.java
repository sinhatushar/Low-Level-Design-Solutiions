package com.rental.vehicle.repository;

import com.rental.vehicle.exceptions.InvalidIdException;
import com.rental.vehicle.model.branch.Branch;
import com.rental.vehicle.model.vehicle.Vehicle;

import java.util.*;

public class BranchRepository {

    public static Map<String, Branch> branchMap = new HashMap<>();
    public static List<Branch> branches = new ArrayList<>();

    public Branch getBranch(String branchId) throws InvalidIdException{
        Branch branch = branchMap.get(branchId);
        if (branch == null)
            throw new InvalidIdException("Branch Id is invalid");

        return branch;
    }

    public Optional<Branch> getBranchByName(String branchName) {
        Optional<Branch> rBranch = branches
                                        .stream()
                                        .filter(branch -> branch.getName().equals(branchName))
                                        .findFirst();

        return rBranch;
    }

    public List<Branch> getAllBranches() {
        return branches;
    }

    public boolean isPresent(String branchName) {
        Optional<Branch> rBranch = branches.stream()
                                          .filter(branch -> branch.getName().equals(branchName))
                                          .findAny();
        return rBranch.isPresent();
    }

    public boolean addBranch(Branch branch){
        Branch oldBranch = branchMap.putIfAbsent(branch.getBranchId(), branch);
        if(oldBranch != null)
            return false;

        branches.add(branch);
        return true;
    }

    public Branch addVehicleToBranch(String branchId, Vehicle vehicle){
        Branch branch = getBranch(branchId);
        branch.addVehicle(vehicle);

        return branch;
    }

    public void removeBranch(String branchId) throws InvalidIdException{
        Branch branch = branchMap.remove(branchId);
        if(branch == null)
            throw new InvalidIdException("Branch Id is invalid");

        for (Branch iBranch : branches) {
            if (iBranch.getBranchId().equals(branchId)) {
                branches.remove(iBranch);
                break;
            }
        }
    }
}