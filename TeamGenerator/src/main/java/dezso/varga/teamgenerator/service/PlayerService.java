package dezso.varga.teamgenerator.service;

import dezso.varga.teamgenerator.GoogleDocReader;
import dezso.varga.teamgenerator.Player;

import java.util.List;

/**
 * Created by varga on 13.09.2015.
 */
public class PlayerService {

    public static List<Player> getAllPlayers(){

        return new GoogleDocReader().getPlayersFromJson();
    }
}
