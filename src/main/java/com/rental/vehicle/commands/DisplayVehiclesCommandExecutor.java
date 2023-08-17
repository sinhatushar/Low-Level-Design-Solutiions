package com.rental.vehicle.commands;

import com.rental.vehicle.exceptions.InvalidCommandException;
import com.rental.vehicle.model.Command;
import com.rental.vehicle.service.DisplayService;

import java.util.List;

public class DisplayVehiclesCommandExecutor extends CommandExecutor {

    String branchName;
    int startDay, endDay;

    public DisplayVehiclesCommandExecutor(Command command) {
        super(command);
        List<String> params = command.getParams();

        try {
            branchName = params.get(0);
            startDay = Integer.parseInt(params.get(1));
            endDay = Integer.parseInt(params.get(2));
        }
        catch (Exception e){
            System.out.println(e);
            throw new InvalidCommandException("Invalid Display Vehicle command");
        }
    }

    @Override
    public boolean execute() {
        DisplayService displayService = new DisplayService();
        displayService.display(branchName, startDay, endDay);
        return true;
    }
}