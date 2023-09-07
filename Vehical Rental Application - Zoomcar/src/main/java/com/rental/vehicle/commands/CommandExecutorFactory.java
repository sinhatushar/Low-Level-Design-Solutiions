package com.rental.vehicle.commands;

import com.rental.vehicle.exceptions.InvalidCommandException;
import com.rental.vehicle.model.Command;

/**
 * Factory to get correct {@link CommandExecutor} from a given command.
 */
public class CommandExecutorFactory {
    /**
     * Gets {@link CommandExecutor} for a particular command. It basically uses name of command to
     * fetch its corresponding executor.
     *
     * @param command Command for which executor has to be fetched.
     * @return Command executor.
     */
    public static CommandExecutor getCommandExecutor(final Command command) {

//        System.out.println(command.getCommandName());
        switch(command.getCommandName()){
            case "ADD_BRANCH" :
                return new AddBranchCommandExecutor(command);
            case "ADD_VEHICLE" :
                return new AddVehicleCommandExecutor(command);
            case "BOOK" :
                return new BookVehicleCommandExecutor(command);
            case "DISPLAY_VEHICLES" :
                return new DisplayVehiclesCommandExecutor(command);
            default:
                throw new InvalidCommandException("Command is Invalid");
        }
    }
}