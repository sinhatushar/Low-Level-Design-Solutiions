package com.rental.vehicle.service;

import com.rental.vehicle.model.vehicle.VehicleType;
import com.rental.vehicle.repository.AccountRepository;
import com.rental.vehicle.repository.BranchRepository;
import com.rental.vehicle.repository.VehicleRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BranchServiceTest {

    @Before
    public void clean() {
        VehicleRepository.vehicleMap.clear();
        VehicleRepository.vehicles.clear();
        AccountRepository.accountMap.clear();
        AccountRepository.accounts.clear();
        VehicleRepository.vehicleMap.clear();
        VehicleRepository.vehicles.clear();
        BranchRepository.branchMap.clear();
        BranchRepository.branches.clear();
    }

    @Test
    public void testCreateBranch(){
        BranchService branchService = new BranchService();

        List<VehicleType> list = new ArrayList<>();
        list.add(VehicleType.CAR);
        list.add(VehicleType.BUS);
        assertTrue(branchService.onboardBranch("B1", list)) ;
        assertFalse(branchService.onboardBranch("B1", list)) ;
    }
}