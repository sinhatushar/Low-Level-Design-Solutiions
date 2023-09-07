package com.rental.vehicle.service;

import com.rental.vehicle.repository.AccountRepository;
import com.rental.vehicle.repository.BranchRepository;
import com.rental.vehicle.repository.VehicleRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AccountServiceTest {

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
    public void testCreateAccount(){
        AccountService accountService = new AccountService();
        assertTrue( accountService.createAccount("testAdmin", "testAdmin@vehiclerental.com"));
        assertFalse( accountService.createAccount("testAdmin", "testAdmin@vehiclerental.com"));
    }
}