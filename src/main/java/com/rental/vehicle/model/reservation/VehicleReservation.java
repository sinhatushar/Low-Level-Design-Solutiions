package com.rental.vehicle.model.reservation;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
public class VehicleReservation {
    private final String reservationId;
    private final String userId; // For everything in the current system, user will be equal to that of ADMIN's id
    private final String associatedVehicleId;

    private final double totalCost;
    @Setter private ReservationStatus status;

    @Setter private int startDay;
    @Setter private int endDay;

    public VehicleReservation(@NonNull String reservationId, @NonNull String userId, @NonNull String associatedVehicleId,
                              @NonNull double totalCost, @NonNull int startDay, @NonNull int endDay) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.associatedVehicleId = associatedVehicleId;
        this.totalCost = totalCost;
        this.status = ReservationStatus.CONFIRMED;
        this.startDay = startDay;
        this.endDay = endDay;
    }
}