package com.rental.vehicle.service;

import com.rental.vehicle.model.vehicle.VehicleType;
import com.rental.vehicle.repository.AccountRepository;
import com.rental.vehicle.repository.BranchRepository;
import com.rental.vehicle.repository.VehicleRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DisplayServiceTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        VehicleRepository.vehicleMap.clear();
        VehicleRepository.vehicles.clear();
        AccountRepository.accountMap.clear();
        AccountRepository.accounts.clear();
        VehicleRepository.vehicleMap.clear();
        VehicleRepository.vehicles.clear();
        BranchRepository.branchMap.clear();
        BranchRepository.branches.clear();
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void out() {
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
        bookingService.book("B1", VehicleType.CAR, 1, 5);
        bookingService.book("B1", VehicleType.BUS, 1, 3);
        bookingService.book("B1", VehicleType.CAR, 1, 3);

        DisplayService displayService = new DisplayService();
        displayService.display("B1", 1, 5);
        assertEquals("", outContent.toString());
    }
}