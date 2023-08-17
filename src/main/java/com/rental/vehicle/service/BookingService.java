package com.rental.vehicle.service;

import com.rental.vehicle.model.account.Account;
import com.rental.vehicle.model.branch.Branch;
import com.rental.vehicle.model.reservation.VehicleReservation;
import com.rental.vehicle.model.vehicle.Vehicle;
import com.rental.vehicle.model.vehicle.VehicleType;
import com.rental.vehicle.repository.AccountRepository;
import com.rental.vehicle.repository.BranchRepository;
import com.rental.vehicle.repository.VehicleRepository;
import com.rental.vehicle.repository.VehicleReservationRepository;
import com.rental.vehicle.strategies.booking.BookingStrategy;
import com.rental.vehicle.strategies.booking.CheapestFirstStrategy;
import com.rental.vehicle.strategies.dynamic.pricing.DynamicPricingStrategy;
import com.rental.vehicle.strategies.pricing.PricingStrategy;
import com.rental.vehicle.strategies.pricing.SameCostForEveryDayStrategy;
import com.rental.vehicle.strategies.search.SearchByVehicleTypeStrategy;
import com.rental.vehicle.strategies.search.SearchStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Getter
@Setter
public class BookingService {

    private VehicleReservationRepository vehicleReservationRepository;
    private BranchRepository branchRepository;
    private AccountRepository accountRepository;    
    private VehicleRepository vehicleRepository;

    private SearchStrategy searchStrategy;
    private PricingStrategy pricingStrategy;
    private BookingStrategy bookingStrategy;
    private DynamicPricingStrategy dynamicPricingStrategy;

    public BookingService(){
        bookingStrategy = new CheapestFirstStrategy();
        vehicleReservationRepository = new VehicleReservationRepository();
        branchRepository = new BranchRepository();
        accountRepository = new AccountRepository();
        vehicleRepository = new VehicleRepository();
    }

    public double book(String branchName, VehicleType vehicleType, int startDay, int endDay){
        Optional<Branch> branch = branchRepository.getBranchByName(branchName);
        if(branch.isEmpty())  // Branch with given branch name doesn't exist
            return -1;

        // Doing the booking from the first admin account
        List<Account> adminAccounts = accountRepository.getAllAccounts();
        Account bookingAccount = adminAccounts.get(0);

        // Searching vehicle by type
        SearchStrategy searchStrategy = new SearchByVehicleTypeStrategy(branch.get(), vehicleType, startDay, endDay);
        List<Vehicle> availableVehiclesForBooking = searchStrategy.search();
        if(availableVehiclesForBooking.size() == 0)  // No vehicle is available for booking
            return -1;

        // Booking the cheapest available vehicle
        bookingStrategy = new CheapestFirstStrategy();
        Vehicle selectedVehicle = bookingStrategy.select(availableVehiclesForBooking);


        String vehicleReservationId = UUID.randomUUID().toString();

        // By default, we are using same cost for everyday strategy
        pricingStrategy = new SameCostForEveryDayStrategy(startDay, endDay, selectedVehicle);
        double totalCost = pricingStrategy.calculateCost();

        VehicleReservation vehicleReservation =
                vehicleReservationRepository
                        .book(new VehicleReservation(vehicleReservationId,
                                bookingAccount.getId(), selectedVehicle.getId(), totalCost , startDay, endDay));

        return totalCost;
    }
}

//    BOOK Booking Price, if booking succeeds else -1	book a vehicle - (Branch id, vehicle type, start time, end time)