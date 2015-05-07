import java.util.ArrayList;
import java.util.Random;

/**
 * Created by dezsovarga on 5/7/15.
 */
public class Utils {

    public static Team generateRandomTeam(ArrayList<Player> players, int teamSize, String teamName){
        Team team = new Team(teamName);
//        int teamSize = players.size()/2;
        int playersSize = players.size();
        Random randomGenerator = new Random();
        int randomNumber = 0;
        Player player = null;

        while (team.getTeamSize()<teamSize){
            randomNumber = randomGenerator.nextInt(playersSize);
            player = players.get(randomNumber);
            team.addPlayer(player);
            players.remove(player);
            playersSize--;
        }
        return team;
    }
}
