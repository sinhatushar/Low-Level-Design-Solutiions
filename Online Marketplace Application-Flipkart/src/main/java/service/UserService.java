package service;

import model.Address;
import model.User;

public interface UserService {
    User createUser(String name, String email, String password, Address address);

    User getUser(String userId);
}
