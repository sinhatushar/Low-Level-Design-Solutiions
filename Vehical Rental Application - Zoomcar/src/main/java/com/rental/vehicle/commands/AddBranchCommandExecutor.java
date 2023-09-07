package com.rental.vehicle.commands;

import com.rental.vehicle.exceptions.InvalidCommandException;
import com.rental.vehicle.model.Command;
import com.rental.vehicle.model.vehicle.VehicleType;
import com.rental.vehicle.service.BranchService;

import java.util.ArrayList;
import java.util.List;

public class AddBranchCommandExecutor extends CommandExecutor{

    String branchName;
    List<VehicleType> vehicleTypes;

    public AddBranchCommandExecutor(Command command) {
        super(command);
        List<String> params = command.getParams();
        vehicleTypes = new ArrayList<>();

        try {
            branchName = params.get(0);
            String types = params.get(1);
            String[] vehicleTypesArr = types.split(",");

//            System.out.println(params);
            int n = vehicleTypesArr.length;
            for (int i = 0; i < n; i++) {
                switch (vehicleTypesArr[i]) {
                    case "BICYCLE":
                        vehicleTypes.add(VehicleType.BICYCLE);
                        break;
                    case "BIKE":
                        vehicleTypes.add(VehicleType.BIKE);
                        break;
                    case "BUS":
                        vehicleTypes.add(VehicleType.BUS);
                        break;
                    case "CAR":
                        vehicleTypes.add(VehicleType.CAR);
                        break;
                    case "TRUCK":
                        vehicleTypes.add(VehicleType.TRUCK);
                        break;
                    case "VAN":
                        vehicleTypes.add(VehicleType.VAN);
                        break;
                    default:
                        throw new InvalidCommandException("Invalid Add Branch command");
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
            throw new InvalidCommandException("Invalid Add Branch command");
        }
    }

    @Override
    public boolean execute() {
        BranchService branchService = new BranchService();
//        System.out.println(branchName);
//        System.out.println(vehicleTypes);
        boolean success = branchService.onboardBranch(branchName, vehicleTypes);
        if(success){
            System.out.println("TRUE");
        }
        else {
            System.out.println("FALSE");
        }
        return success;
    }
}