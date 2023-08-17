package com.rental.vehicle.commands;

import com.rental.vehicle.model.Command;
import lombok.AllArgsConstructor;

/**
 * Command executor interface.
 */
@AllArgsConstructor
public abstract class CommandExecutor {

    Command command;

    /**
     * Executes the command.
     */
    public abstract boolean execute();
}