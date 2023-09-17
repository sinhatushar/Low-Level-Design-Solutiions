package Repository;

import exception.PlayerNotFoundException;
import model.Player;

import java.util.*;

public class PlayerRepository {
    private static final Map<String, Player> players = new HashMap<>();
    private static final List<Player> playerList = new ArrayList<>();

    public Player getPlayer(String name) {
        Player player = players.get(name);
        if(player == null){
            throw new PlayerNotFoundException(name);
        }
        return player;
    }

    public Player createPlayer(Player player) {
        players.put(player.getName(), player);
        playerList.add(player);
        return player;
    }

    public List<Player> getAll() {
        return new ArrayList<>(playerList);
    }
}
