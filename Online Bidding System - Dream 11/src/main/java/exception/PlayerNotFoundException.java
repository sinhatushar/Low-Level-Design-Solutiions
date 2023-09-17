package exception;

public class PlayerNotFoundException extends FPLException{
    public PlayerNotFoundException(String name) {
        super("Player with name : " + name + " not found !");
    }
}
