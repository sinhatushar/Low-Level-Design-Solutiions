package service;

import exception.UserNotFoundException;
import model.Address;
import model.User;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private final Map<String, User> users = new HashMap<>();

//  TODO: private Map<String, User> users = new ConcurrentHashMap<>();

    @Override
    public User createUser(String name, String email, String password, Address address) {
        // TODO: Validation and user creation logic + EXCEPTIONS
        User user = new User(name, email, password, address);
        users.put(user.getUserId(), user);
        return user;
    }

    @Override
    public User getUser(String userId) {
        User user = users.get(userId);
        if (user == null) {
            throw new UserNotFoundException(userId);
        }
        return user;
    }
}
