package exception;

public class DuplicateTeamNameException extends FPLException{
    public DuplicateTeamNameException(String name) {
        super("Team with name : " + name + " is already present in the system !");
    }
}
