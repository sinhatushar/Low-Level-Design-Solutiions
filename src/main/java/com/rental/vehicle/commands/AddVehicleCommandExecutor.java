package com.rental.vehicle.commands;

import com.rental.vehicle.exceptions.InvalidCommandException;
import com.rental.vehicle.model.Command;
import com.rental.vehicle.model.vehicle.VehicleType;
import com.rental.vehicle.service.VehicleService;

import java.util.List;

public class AddVehicleCommandExecutor extends CommandExecutor{

    String branchName, vehicleId;
    double costPerDay;
    VehicleType vehicleType;

    public AddVehicleCommandExecutor(Command command) {
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
                    throw new InvalidCommandException("Invalid Add Branch command");
            }

            vehicleId = params.get(2);
            costPerDay = Double.parseDouble(params.get(3));
        }
        catch (Exception e) {
            System.out.println(e);
            throw new InvalidCommandException("Invalid Add Vehicle Command");
        }
    }

    @Override
    public boolean execute() {
        VehicleService vehicleService = new VehicleService();

        boolean success = vehicleService.onboardVehicle(branchName, vehicleType, vehicleId, costPerDay);
        if(success){
            System.out.println("TRUE");
        }
        else {
            System.out.println("FALSE");
        }
        return success;
    }
}