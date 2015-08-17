import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dezsovarga on 5/7/15.
 */
public class Utils {

    public static List<Player> getRegisteredPlayers(List<String> playerNames, List<Player> allPlayers){
        List<Player> registeredPlayers = new ArrayList<Player>();

        //adding new players directly to registered players list
        for (String playerName: playerNames){
            if (playerName.contains(" ") ){
                String playerItems[] = playerName.split(" ");
                String name = playerItems[0];
                int skill = Integer.parseInt(playerItems[1]);
                registeredPlayers.add(new Player(name,skill));
                playerNames.remove(playerName);
            }
        }

        for (Player player:allPlayers){

            for (String playerName:playerNames){
                if (player.getName().toUpperCase().contains(playerName.toUpperCase())){
                    registeredPlayers.add(player);
                }
            }

        }

        return registeredPlayers;
    }

    public static Team generateRandomTeam(List<Player> players, int teamSize, String teamName){
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

    public static void switchPlayer(Player player, Team team1, Team team2){
        team1.removePlayer(player);
        team2.addPlayer(player);
    }

    public static int equalizeTeams(Team team1, Team team2, List<Player> registeredPlayers){
        int triedIndex = 0;
        while (Math.abs(team1.getSkillSum() - team2.getSkillSum()) >= 200){
            if (team1.getSkillSum() > team2.getSkillSum()){
                Player randomPlayer = team1.getRandomPlayer();
                Player weakerPlayer = team2.getPlayerWeakerThan(randomPlayer);
                switchPlayer(randomPlayer, team1, team2);
                switchPlayer(weakerPlayer, team2, team1);
            }
            else{
                Player randomPlayer = team2.getRandomPlayer();
                Player weakerPlayer = team1.getPlayerWeakerThan(randomPlayer);
                switchPlayer(randomPlayer, team2, team1);
                switchPlayer(weakerPlayer, team1, team2);
            }
            triedIndex++;
            if (triedIndex == 1000){
                System.out.println("Breaking out");
                break;
            }

        }

        System.out.println("Tried: "+ triedIndex);
        System.out.println("Team difference: "+Math.abs(team1.getSkillSum() - team2.getSkillSum()));
        return triedIndex;
    }
}
