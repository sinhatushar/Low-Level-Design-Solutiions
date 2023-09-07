package com.rental.vehicle;

import com.rental.vehicle.commands.CommandExecutor;
import com.rental.vehicle.commands.CommandExecutorFactory;
import com.rental.vehicle.model.Command;
import com.rental.vehicle.service.AccountService;

import java.io.*;

public class VehicleRental {

    public static void main(String[] args) throws IOException {

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileLocation   = args[0];

        File inputFile                = new File(fileLocation);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));

        // Creating an account for admin. As per the problem statement, there are no users present in the system.
        // Hence, there is only one account which is that of admin.
        AccountService accountService = new AccountService();
        accountService.createAccount("adminId", "admin@vehicalrental.com");

        String currentLine;
        while((currentLine = bufferedReader.readLine()) != null){
            // Use of command design pattern.
            Command command = new Command(currentLine);
            CommandExecutor commandExecutor = CommandExecutorFactory.getCommandExecutor(command);
            commandExecutor.execute();
        }
    }
}