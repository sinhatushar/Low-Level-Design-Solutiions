package service;

import Repository.BidRepository;
import Repository.PlayerRepository;
import lombok.AllArgsConstructor;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class PlayerService {
    private PlayerRepository playerRepository;

    public Player addPlayer(String name, int basePrice, PlayerNationality playerNationality, PlayerType playerType){
        Player player = Player.builder()
                .id(UUID.randomUUID().toString())
                .playerType(playerType)
                .playerNationality(playerNationality)
                .basePrice(basePrice)
                .name(name)
                .bidsForPlayer(new ArrayList<>())
                .playerStatus(PlayerStatus.DRAFT)
                .sellingPrice(-1)
                .build();

        return playerRepository.createPlayer(player);
    }

    public List<Bid> getAllBidsForPlayer(String name) {
        Player player = playerRepository.getPlayer(name);
        return player.getBidsForPlayer();
    }

    public List<Player> playerOverview() {
        return playerRepository.getAll();
    }
}
