package exception;

public class TeamNotFoundException extends FPLException{
    public TeamNotFoundException(String name) {
        super("Team with name : " + name + " not found !");
    }
}
