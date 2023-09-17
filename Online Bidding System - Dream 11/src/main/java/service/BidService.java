package service;

import Repository.BidRepository;
import Repository.PlayerRepository;
import Repository.TeamRepository;
import lombok.AllArgsConstructor;
import model.Bid;
import model.Player;
import model.Team;

import java.util.UUID;

@AllArgsConstructor
public class BidService {
    private TeamRepository teamRepository;
    private PlayerRepository playerRepository;
    private BidRepository bidRepository;

    public Bid addBid(String teamName, String playerName, int bidAmount){
        Player player = playerRepository.getPlayer(playerName);
        Team team = teamRepository.getTeam(teamName);

        if(team.getWalletAmount() < bidAmount){
            throw new RuntimeException("Can't bid for more than wallet amount ");
        }

//        if(bidAmount < currentMaxBid){
//            throw new RuntimeException("Need higher bid value than current bid value");
//        }

//        currentMaxBid = bidAmount;
        Bid bid = Bid.builder()
                .id(UUID.randomUUID().toString())
                .player(player)
                .team(team)
                .bidAmount(bidAmount)
                .build();

        player.addBid(bid);
        team.addBid(bid);

        return bidRepository.createBid(bid);
    }
}
