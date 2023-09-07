package com.rental.vehicle.service;

import com.rental.vehicle.model.account.Account;
import com.rental.vehicle.model.account.Admin;
import com.rental.vehicle.repository.AccountRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountService {

    AccountRepository accountRepository;

    public AccountService() {
        this.accountRepository = new AccountRepository();
    }

    public boolean createAccount(String id, String email) {

//        Optional<Account> oldAccount = accountRepository
//                                            .getAllAccounts()
//                                            .stream()
//                                            .filter(account -> account.getId().equals(id))
//                                            .findAny();
//
//        if(oldAccount.isPresent())
//            return false;
//
        Account account = new Admin(id, email);     //Only Admin is present in the system right now.
        return accountRepository.addAccount(account);
    }
}