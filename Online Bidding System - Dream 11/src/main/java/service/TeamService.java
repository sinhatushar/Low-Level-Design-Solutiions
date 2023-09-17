package service;

import Repository.TeamRepository;
import lombok.AllArgsConstructor;
import model.Bid;
import model.Player;
import model.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class TeamService {
    private TeamRepository teamRepository;

    public Team addTeam(String name, int walletAmount) {
        Team team = Team.builder()
                .id(UUID.randomUUID().toString())
                .name(name)
                .walletAmount(walletAmount)
                .purchasedPlayers(new ArrayList<>())
                .bidsByTeam(new ArrayList<>())
                .build();

        return teamRepository.createTeam(team);
    }

    public List<Bid> getAllBidsByTeam(String name) {
        Team team = teamRepository.getTeam(name);
        return team.getBidsByTeam();
    }

    public List<Team> teamOverview() {
        return teamRepository.getAll();
    }
}
