package exception;

public class BidNotFoundException extends FPLException{
    public BidNotFoundException(String id) {
        super("Bid with id : " + id + " not found !");
    }
}