package teamgenerator;

import java.io.IOException;
import java.net.URISyntaxException;
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

    private static void addTeamPair(List<TeamPair> teamPairList, TeamPair teamPair){

        boolean val = false;
        for (TeamPair teamPairElem: teamPairList){
            if (teamPairElem.getTeamDiff() == teamPair.getTeamDiff()){
                val = true;
            }
        }
        if (!val){
            teamPairList.add(teamPair);
        }

    }

    public static List<TeamPair> equalizeTeams(Team team1, Team team2, List<Player> registeredPlayers) throws IOException, URISyntaxException{
        int triedIndex = 0;
        int diff = 600;
        int minDiff = -1;
        Team team1_ = null;
        Team team2_ = null;
        TeamPair teamPair;
        List teamPairList = new ArrayList<TeamPair>();

        triedIndex = 0;
        while (Math.abs(team1.getSkillSum() - team2.getSkillSum()) >= minDiff){
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
            diff = Math.abs(team1.getSkillSum() - team2.getSkillSum());
            if (diff < 400) {
                minDiff = diff;
                team1_ = new Team(team1);
                team2_ = new Team(team2);
                teamPair = new TeamPair(team1_, team2_);
                if (isLegalTeamPair(teamPair)){
                    addTeamPair(teamPairList, teamPair);
                }

            }
        }
        return teamPairList;
    }

    private static boolean isLegalTeamPair(TeamPair teamPair) throws IOException, URISyntaxException{

        List<String> separatedPlayers = FileReader.readFileByLines("stipulation.txt");
        String p1 = "";
        String p2 = "";

        for (String sepPlayers:separatedPlayers){
            p1 = sepPlayers.split(" ")[0];
            p2 = sepPlayers.split(" ")[1];

            if (contains(teamPair.getTeam2().players,p1) && contains(teamPair.getTeam2().players,p2)){
                return false;
            }

            if (contains(teamPair.getTeam1().players,p1) && contains(teamPair.getTeam1().players,p2)){
                return false;
            }
        }

        return true;
    }

    private static boolean contains(ArrayList<Player> players, String playersName){

        for (Player player:players){
            if (player.getName().trim().equals(playersName)){
                return true;
            }
        }
        return false;
    }
}
