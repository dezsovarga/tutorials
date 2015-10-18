package dezso.varga.teamgenerator.rest.resources;

import dezso.varga.teamgenerator.domain.Player;
import dezso.varga.teamgenerator.rest.services.PlayerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by varga on 13.09.2015.
 */

@Path("/players")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlayersResource {

    PlayerService playerService = new PlayerService();

    @GET
    public List<Player> getPlayers() {
        return PlayerService.getAllPlayers();
    }

    @GET
    @Path("/{playerName}")
    public Player getPlayer(@PathParam("playerName") String playerName){
        return PlayerService.getPlayer(playerName);
    }


}
