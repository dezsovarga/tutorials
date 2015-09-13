package dezso.varga.teamgenerator.resources;

import dezso.varga.teamgenerator.Player;
import dezso.varga.teamgenerator.service.PlayerService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by varga on 13.09.2015.
 */

@Path("/players")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlayersResource {

    @GET
    public List<Player> getPlayers(){
        return PlayerService.getAllPlayers();
    }

}
