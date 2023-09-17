package service;

import model.Bid;
import model.Player;
import model.PlayerStatus;
import model.Team;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

public class AuctionService {
    Player currentBiddingPlayer;
    TreeSet<Bid> validBidsForPlayer;

    public void startAuction(Player player) {
        currentBiddingPlayer = player;
        validBidsForPlayer = new TreeSet<>(Comparator.comparing(Bid::getBidAmount).reversed());
    }

    public void placeBid(Bid bid){
        if(bid.getBidAmount() > currentBiddingPlayer.getBasePrice()){
            validBidsForPlayer.add(bid);
        } else {
            throw new RuntimeException("Bid price must be higher than player's baseprice");
        }

        // Else {Thrown an exception}
    }

    public Team closeAuction(){
        Bid bid;
        try{
            bid = validBidsForPlayer.first();
        } catch (NoSuchElementException exception){
            currentBiddingPlayer.setTeam(null);
            currentBiddingPlayer.setPlayerStatus(PlayerStatus.UNSOLD);
            return null;
        }

        Team bidWinningTeam = bid.getTeam();
        bidWinningTeam.addPlayer(currentBiddingPlayer);
        bidWinningTeam.setWalletAmount(bidWinningTeam.getWalletAmount()- bid.getBidAmount());

        currentBiddingPlayer.setSellingPrice(bid.getBidAmount());
        currentBiddingPlayer.setTeam(bid.getTeam());
        currentBiddingPlayer.setPlayerStatus(PlayerStatus.SOLD);

        return bidWinningTeam;
    }
}
