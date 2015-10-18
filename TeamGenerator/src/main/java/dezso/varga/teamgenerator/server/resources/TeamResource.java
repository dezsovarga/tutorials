package dezso.varga.teamgenerator.server.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import dezso.varga.teamgenerator.domain.Player;
import dezso.varga.teamgenerator.domain.TeamPair;
import dezso.varga.teamgenerator.domain.Utils;
import dezso.varga.teamgenerator.rest.service.PlayerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by varga on 18.10.2015.
 */
@Path("/teams")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeamResource {

    static ObjectMapper mapper = new ObjectMapper();

    @POST
    @Path("/generate")
    @Consumes(MediaType.APPLICATION_JSON)
    public TeamPair generateTeams(String registeredPlayersJson) throws IOException{

        List<String> registeredPlayerNames = Arrays.asList(mapper.readValue(registeredPlayersJson, String[].class));
        List<Player> registeredPlayers = Utils.getRegisteredPlayers(registeredPlayerNames, PlayerService.getAllPlayers());
        return null;

    }
}
