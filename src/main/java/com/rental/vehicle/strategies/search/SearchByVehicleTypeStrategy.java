package com.rental.vehicle.strategies.search;

import com.rental.vehicle.model.branch.Branch;
import com.rental.vehicle.model.reservation.VehicleReservation;
import com.rental.vehicle.model.vehicle.Vehicle;
import com.rental.vehicle.model.vehicle.VehicleType;
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
public class SearchByVehicleTypeStrategy implements SearchStrategy {

    private Branch branch;
    private VehicleType vehicleType;
    private int startDay, endDay;

    // find all available vehicles for a branch and vehicleType for a given startTime and endTime
    @Override
    public List<Vehicle> search() {

        VehicleRepository vehicleRepository = new VehicleRepository();
        VehicleReservationRepository vehicleReservationRepository = new VehicleReservationRepository();

        Set<String> notAvailableVehiclesInBranchOfGivenVehicleType =
                vehicleReservationRepository
                        .getAll()
                        .stream()
                        .filter(vehicleReservation -> {
                            Vehicle vehicleInvolved = vehicleRepository.getVehicle(vehicleReservation.getAssociatedVehicleId());
                            String branchIdForVehicleInvolved = vehicleInvolved.getAssociatedBranchId();
                            VehicleType vehicleTypeForVehicleInvolved = vehicleInvolved.getVehicleType();

                            return branchIdForVehicleInvolved.equals(branch.getBranchId())
                                    && (vehicleTypeForVehicleInvolved.equals(vehicleType))
                                    && ((vehicleReservation.getStartDay() >= startDay && vehicleReservation.getStartDay() < endDay)
                                    || (vehicleReservation.getEndDay() > startDay && vehicleReservation.getEndDay() <= endDay));
                        })
                        .map(VehicleReservation::getAssociatedVehicleId)
                        .collect(Collectors.toSet());

        List<Vehicle> availableVehiclesInBranchOfGivenVehicleType =
                branch.getVehiclesList()
                        .stream()
                        .filter(vehicle -> !notAvailableVehiclesInBranchOfGivenVehicleType.contains(vehicle.getId())
                                            && vehicle.getVehicleType().equals(vehicleType))
                        .collect(Collectors.toList());

        return availableVehiclesInBranchOfGivenVehicleType;
    }
}