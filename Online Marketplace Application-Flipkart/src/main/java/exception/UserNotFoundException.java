package exception;

public class UserNotFoundException extends MarketplaceException {
    public UserNotFoundException(String userId) {
        super("User not found for userId: " + userId);
    }
}
