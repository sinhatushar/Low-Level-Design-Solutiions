package com.rental.vehicle.commands;

import com.rental.vehicle.exceptions.InvalidCommandException;
import com.rental.vehicle.model.Command;
import com.rental.vehicle.model.vehicle.VehicleType;
import com.rental.vehicle.service.BookingService;

import java.util.List;

public class BookVehicleCommandExecutor extends CommandExecutor{

    String branchName;
    int startDay, endDay;
    VehicleType vehicleType;

    public BookVehicleCommandExecutor(Command command) {
        super(command);
        List<String> params = command.getParams();

        try {
            branchName = params.get(0);

            switch (params.get(1)) {
                case "BICYCLE":
                    vehicleType = VehicleType.BICYCLE;
                    break;
                case "BIKE":
                    vehicleType = VehicleType.BIKE;
                    break;
                case "BUS":
                    vehicleType = VehicleType.BUS;
                    break;
                case "CAR":
                    vehicleType = VehicleType.CAR;
                    break;
                case "TRUCK":
                    vehicleType = VehicleType.TRUCK;
                    break;
                case "VAN":
                    vehicleType = VehicleType.VAN;
                    break;
                default:
                    throw new InvalidCommandException("Invalid Book Vehicle command");
            }

            startDay = Integer.parseInt(params.get(2));
            endDay = Integer.parseInt(params.get(3));
        }
        catch (Exception e){
            System.out.println(e);
            throw new InvalidCommandException("Invalid Book Vehicle command");
        }
    }

    @Override
    public boolean execute() {
        BookingService bookingService = new BookingService();
        double cost = bookingService.book(branchName, vehicleType, startDay, endDay);
        if(cost == -1d)
            System.out.println(-1);
        else
            System.out.println((int)cost);
        return cost == -1;
    }
}