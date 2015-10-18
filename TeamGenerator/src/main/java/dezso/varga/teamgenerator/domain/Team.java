package dezso.varga.teamgenerator.domain;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by dezsovarga on 5/7/15.
 */
@XmlRootElement
public class Team {

    String name;
    ArrayList<Player> players = new ArrayList<Player>();
    public Team(){

    }

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

    public Team(Team team){

        this.name = team.name;
        this.players.addAll(team.players);
    }

    public Player getRandomPlayer(){
        Random randomGenerator = new Random();
        int randomIndex = randomGenerator.nextInt(players.size());
        return players.get(randomIndex);
    }

    public Player getPlayerWeakerThan(Player player){
        for (Player playerItem:players){
            if (playerItem.getSkill()< player.getSkill()){
                return playerItem;
            }
        }
        return players.get(0);
    }

    public int getSkillSum(){
        int sum = 0;
        for (Player player:players){
            sum = sum + player.getSkill();
        }
        return sum;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString(){
        String s="Team " + name + " - "+getSkillSum() +"\n";
        for (Player player:players){
            s=s+(player.toString()/*+"\n"*/);
        }
        return s;
    }
}
