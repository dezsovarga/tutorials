import java.util.ArrayList;

/**
 * Created by dezsovarga on 5/7/15.
 */
public class Team {

    String name;
    ArrayList<Player> players = new ArrayList<Player>();

    public Team(String name) {
        this.name = name;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void removePlayer(Player player){
        players.remove(player);
    }

    public int getTeamSize(){
        return players.size();
    }

    public int getSkillSum(){
        int sum = 0;
        for (Player player:players){
            sum = sum + player.getSkill();
        }
        return sum;
    }

    @Override
    public String toString(){
        String s="Team " + name + " - "+getSkillSum() +"\n";
        for (Player player:players){
            s=s+(player.toString()+"\n");
        }
        return s;
    }
}
