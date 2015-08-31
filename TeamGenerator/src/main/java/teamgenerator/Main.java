package teamgenerator;

import java.io.IOException;
import java.lang.System;
import java.net.URISyntaxException;
import java.util.*;

public class Main
{
	public static void main(String [] args) throws IOException, URISyntaxException{

        List<Player> allPlayers = new GoogleDocReader().getPlayersFromJson();

        List<String> registeredPlayerNames = FileReader.getRegisteredPlayerNames("registered_players.txt");
        List<Player> registeredPlayers = Utils.getRegisteredPlayers(registeredPlayerNames,allPlayers);

        Team team1 = Utils.generateRandomTeam(registeredPlayers,registeredPlayers.size()/2,"team1");
        Team team2 = Utils.generateRandomTeam(registeredPlayers,registeredPlayers.size(),"team2");

        List<TeamPair> teamPairs = Utils.equalizeTeams(team1, team2, registeredPlayers);

        for (TeamPair teamP:teamPairs){
                System.out.println(teamP);
        }

	}
}