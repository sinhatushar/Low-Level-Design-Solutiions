package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Builder
public class Team {
    String id;
    String name;
    @Setter int walletAmount;
//    int sellingPrice;
    List<Player> purchasedPlayers;
    List<Bid> bidsByTeam;

    public Boolean addBid(Bid bid){
        return bidsByTeam.add(bid);
    }

    public Boolean addPlayer(Player player) {
        return purchasedPlayers.add(player);
    }
}
