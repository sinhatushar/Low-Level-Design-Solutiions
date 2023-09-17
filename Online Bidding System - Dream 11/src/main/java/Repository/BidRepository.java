package Repository;

import exception.BidNotFoundException;
import model.Bid;

import java.util.HashMap;
import java.util.Map;

public class BidRepository {
    private static final Map<String, Bid> bids = new HashMap<>();

    public Bid getBid(String name) {
        Bid bid = bids.get(name);
        if(bid == null){
            throw new BidNotFoundException(name);
        }
        return bid;
    }

    public Bid createBid(Bid bid) {
        bids.put(bid.getId(), bid);
        return bid;
    }
}
