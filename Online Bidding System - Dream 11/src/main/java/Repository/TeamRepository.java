package Repository;

import exception.TeamNotFoundException;
import model.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamRepository {
    private static final Map<String, Team> teams = new HashMap<>();
    private static final List<Team> teamsList = new ArrayList<>();

    public Team getTeam(String name) {
        Team team = teams.get(name);
        if(team == null){
            throw new TeamNotFoundException(name);
        }
        return team;
    }

    public Team createTeam(Team team) {
        teams.put(team.getName(), team);
        teamsList.add(team);
        return team;
    }

    public List<Team> getAll(){
        return new ArrayList<>(teamsList);
    }
}
