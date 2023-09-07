package com.rental.vehicle.service;

import com.rental.vehicle.model.vehicle.VehicleType;
import com.rental.vehicle.repository.AccountRepository;
import com.rental.vehicle.repository.BranchRepository;
import com.rental.vehicle.repository.VehicleRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookingServiceTest {

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
    public void testBooking()
    {
        AccountService accountService = new AccountService();
        accountService.createAccount("testAdmin", "testAdmin@vehiclerental.com");

        BranchService branchService = new BranchService();

        List<VehicleType> list = new ArrayList<>();
        list.add(VehicleType.CAR);
        list.add(VehicleType.BUS);
        branchService.onboardBranch("B1", list) ;

        VehicleService vehicleService = new VehicleService();
        vehicleService.onboardVehicle("B1", VehicleType.CAR, "V1", 500);
        vehicleService.onboardVehicle("B1", VehicleType.CAR, "V2", 1500);
        vehicleService.onboardVehicle("B1", VehicleType.BUS, "V3", 2500);
        vehicleService.onboardVehicle("B1", VehicleType.VAN, "V4", 1000);
        vehicleService.onboardVehicle("B1", VehicleType.BIKE, "V5", 5500);

        BookingService bookingService = new BookingService();
        assertEquals(2000, (int)bookingService.book("B1", VehicleType.CAR, 1, 5));
        assertEquals(5000,(int)bookingService.book("B1", VehicleType.BUS, 1, 3));
        assertEquals(-1, (int)bookingService.book("B1", VehicleType.BUS, 2, 5));
    }
}