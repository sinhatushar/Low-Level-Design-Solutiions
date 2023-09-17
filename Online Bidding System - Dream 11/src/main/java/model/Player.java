package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Builder
public class Player {
    String id;
    String name;
    int basePrice;
    @Setter int sellingPrice;
    PlayerNationality playerNationality;
    @Setter PlayerStatus playerStatus;
    PlayerType playerType;
    public List<Bid> bidsForPlayer;
    @Setter public Team team;

    public boolean addBid(Bid bid){
        return bidsForPlayer.add(bid);
    }
}
