package com.rental.vehicle.repository;

import com.rental.vehicle.exceptions.InvalidIdException;
import com.rental.vehicle.model.reservation.VehicleReservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleReservationRepository {

    public static Map<String, VehicleReservation> vehicleReservationMap = new HashMap<>();
    public static List<VehicleReservation> vehicleReservations = new ArrayList<>();

    public VehicleReservation getVehicleReservation(String reservationId) throws InvalidIdException {
        VehicleReservation reservation = vehicleReservationMap.get(reservationId);
        if(reservation == null)
            throw new InvalidIdException("Reservation Id is invalid");

        return reservation;
    }

    public List<VehicleReservation> getAll() {
        return vehicleReservations;
    }

    public VehicleReservation book(VehicleReservation vehicleReservation) {
        vehicleReservationMap.put(vehicleReservation.getReservationId(), vehicleReservation);

        vehicleReservations.add(vehicleReservation);
        return vehicleReservation;
    }
}