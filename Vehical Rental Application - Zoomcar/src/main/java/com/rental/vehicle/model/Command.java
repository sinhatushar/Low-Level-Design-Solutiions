package com.rental.vehicle.model;

import com.rental.vehicle.exceptions.InvalidCommandException;
import com.rental.vehicle.exceptions.InvalidIdException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Command {

    private static final String SPACE = " ";
    private String commandName;
    private List<String> params;

    public String getCommandName() {
        return commandName;
    }

    public List<String> getParams() {
        return params;
    }

    public Command(final String inputLine) throws InvalidIdException {
        final List<String> tokensList = Arrays.stream(inputLine.trim().split(SPACE))
                .map(String::trim)
                .filter(token -> (token.length() > 0)).collect(Collectors.toList());

        if (tokensList.size() == 0) {
            throw new InvalidCommandException("Command is Invalid");
        }

        commandName = tokensList.get(0);
        tokensList.remove(0);
        params = tokensList;
    }
}