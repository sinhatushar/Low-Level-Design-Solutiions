package com.rental.vehicle.repository;

import com.rental.vehicle.exceptions.InvalidIdException;
import com.rental.vehicle.model.account.Account;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountRepository{

    public static Map<String, Account> accountMap = new HashMap<>();
    public static List<Account> accounts = new ArrayList<>();

    public Account getAccount(String Id) throws InvalidIdException{
        Account account = accountMap.get(Id);
        if(account == null)
            throw new InvalidIdException("Account Id is invalid");

        return account;
    }

    public List<Account> getAllAccounts() {
        return accounts;
    }

    public boolean addAccount(Account account) {
        Account oldAccount = accountMap.putIfAbsent(account.getId(), account);
        if(oldAccount != null)
            return false;

        accounts.add(account);
        return true;
    }
}