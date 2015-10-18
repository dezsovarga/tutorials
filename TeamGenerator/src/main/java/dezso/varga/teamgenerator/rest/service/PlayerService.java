package dezso.varga.teamgenerator.rest.service;

import dezso.varga.teamgenerator.utils.GoogleDocReader;
import dezso.varga.teamgenerator.domain.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by varga on 13.09.2015.
 */
public class PlayerService {

    private static List<Player> allPlayersList;
    {
        if (allPlayersList == null){
            allPlayersList = getAllPlayers();
        }
    }
    public static List<Player> getAllPlayers(){
        allPlayersList = new GoogleDocReader().getPlayersFromJson();
        return allPlayersList;
    }

    public static Player getPlayer(String playerName) {

        for (Player player:allPlayersList){
            if (player.getName().trim().equals(playerName.trim())){
                return player;
            }
        }
        return null;
    }
}
