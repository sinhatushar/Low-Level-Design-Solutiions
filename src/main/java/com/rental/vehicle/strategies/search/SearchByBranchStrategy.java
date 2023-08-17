package com.rental.vehicle.strategies.search;

import com.rental.vehicle.model.branch.Branch;
import com.rental.vehicle.model.reservation.VehicleReservation;
import com.rental.vehicle.model.vehicle.Vehicle;
import com.rental.vehicle.repository.VehicleRepository;
import com.rental.vehicle.repository.VehicleReservationRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class SearchByBranchStrategy implements SearchStrategy {

    private Branch branch;
    private int startDay, endDay;

    // find all available vehicles for a branch for given startTime and endTime
    @Override
    public List<Vehicle> search() {

        VehicleRepository vehicleRepository = new VehicleRepository();
        VehicleReservationRepository vehicleReservationRepository = new VehicleReservationRepository();

        Set<String> notAvailableVehiclesInBranch =
                vehicleReservationRepository
                        .getAll()
                        .stream()
                        .filter(vehicleReservation -> {
                            Vehicle vehicleInvolved = vehicleRepository.getVehicle(vehicleReservation.getAssociatedVehicleId());
                            String branchIdForVehicleInvolved = vehicleInvolved.getAssociatedBranchId();

                            return branchIdForVehicleInvolved.equals(branch.getBranchId())
                                    && ((vehicleReservation.getStartDay() >= startDay && vehicleReservation.getStartDay() < endDay)
                                    || (vehicleReservation.getEndDay() > startDay && vehicleReservation.getEndDay() <= endDay));
                        })
                        .map(VehicleReservation::getAssociatedVehicleId)
                        .collect(Collectors.toSet());


        List<Vehicle> availableVehiclesInBranch =
                branch.getVehiclesList()
                      .stream()
                      .filter(vehicle -> !notAvailableVehiclesInBranch.contains(vehicle.getId()))
                      .collect(Collectors.toList());

        return availableVehiclesInBranch;
    }
}