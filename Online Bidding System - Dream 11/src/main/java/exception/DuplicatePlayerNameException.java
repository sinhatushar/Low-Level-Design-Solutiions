package exception;

public class DuplicatePlayerNameException extends FPLException{
    public DuplicatePlayerNameException(String name) {
        super("Player with name : " + name + " is already present in the system !");
    }
}
