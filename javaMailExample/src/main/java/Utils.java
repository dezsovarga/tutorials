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

//    private static String saveTeamSnapShot(Team team){
//
//        String teamSnapShot = "";
//        for (Player player: team.players){
//            teamSnapShot = teamSnapShot + player.toString()+";";
//        }
//
//        return teamSnapShot;
//    }
//
//    private static void loadTeamSnapShot(String teamSnapShot, Team team){
//
//        String parts[] = teamSnapShot.split(";");
//        ArrayList<Player> playersList = new ArrayList<Player>();
//
//        for (String elems: parts){
//            String player[] = elems.split(" - ");
//            playersList.add(new Player(player[0],Integer.parseInt(player[1]) ));
//        }
//
//        team.players = playersList;
//    }
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

    public static List<TeamPair> equalizeTeams(Team team1, Team team2, List<Player> registeredPlayers){
        int triedIndex = 0;
        int versionIndex = 0;
       // String team1_ = null;
       // String team2_= null;
        int diff = 600;
        int minDiff = -1;
        Team team1_ = null;
        Team team2_ = null;
        TeamPair teamPair = new TeamPair();
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
                addTeamPair(teamPairList, teamPair);
                //teamPairList.add(teamPair);
//                team1_ = saveTeamSnapShot(team1);
//                team2_ = saveTeamSnapShot(team2);
            }
        }

       // team1 = team1_;
        //team2 = team2_;
//        loadTeamSnapShot(team1_, team1);
//        loadTeamSnapShot(team2_, team2);

//        System.out.println(team1);
//        System.out.println(team2);

//        System.out.println("Tried: "+ triedIndex);
//        System.out.println("Team difference: "+Math.abs(team1.getSkillSum() - team2.getSkillSum()));
        return teamPairList;
    }
}
