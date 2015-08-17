import java.io.IOException;
import java.lang.System;
import java.net.URISyntaxException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.xml.transform.sax.SAXSource;

public class Main
{
	public static void main(String [] args) throws IOException, URISyntaxException{

        List<Player> allPlayers = new GoogleDocReader().getPlayersFromJson();

        List<String> registeredPlayerNames = FileReader.getRegisteredPlayerNames("registered_players.txt");
        List<Player> registeredPlayers = Utils.getRegisteredPlayers(registeredPlayerNames,allPlayers);

        ArrayList<Player> players = new ArrayList<Player>();

        Team team1 = Utils.generateRandomTeam(registeredPlayers,registeredPlayers.size()/2,"team1");
        Team team2 = Utils.generateRandomTeam(registeredPlayers,registeredPlayers.size(),"team2");

        /*Player randomPlayer = team1.getRandomPlayer();
        System.out.println("Random player from team 1: " + randomPlayer);
        System.out.println("Weaker Player from team 2: " + team2.getPlayerWeakerThan(randomPlayer));*/

        Utils.equalizeTeams(team1, team2, registeredPlayers);

        System.out.println(team1);
        System.out.println(team2);

        /*Utils.switchPlayer(randomPlayer, team1, team2);

        System.out.println(team1);
        System.out.println(team2);*/
	}
}