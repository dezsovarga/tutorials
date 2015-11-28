package dezso.varga.teamgenerator.rest.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import dezso.varga.teamgenerator.common.exceptions.PlayerNotFoundException;
import dezso.varga.teamgenerator.domain.Player;
import dezso.varga.teamgenerator.domain.Team;
import dezso.varga.teamgenerator.domain.TeamPair;
import dezso.varga.teamgenerator.domain.Utils;
import dezso.varga.teamgenerator.rest.services.PlayerService;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URISyntaxException;
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
    public List<TeamPair> generateTeams(@Context HttpHeaders header, @Context HttpServletResponse response, String registeredPlayersJson) throws IOException, URISyntaxException {

        List<String> registeredPlayerNames = mapper.readValue(registeredPlayersJson, mapper.getTypeFactory().
                constructCollectionType(List.class, String.class));
        if (registeredPlayerNames.size() == 1 && registeredPlayerNames.get(0).toString().equals("")){
            registeredPlayerNames.clear();
        }
        List<Player> registeredPlayers = Utils.getRegisteredPlayers(registeredPlayerNames, PlayerService.getAllPlayers());

        Team team1 = Utils.generateRandomTeam(registeredPlayers,registeredPlayers.size()/2,"team1");
        Team team2 = Utils.generateRandomTeam(registeredPlayers,registeredPlayers.size(),"team2");

        List<TeamPair> teamPairs = Utils.equalizeTeams(team1, team2, registeredPlayers);

        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");

        return teamPairs;
    }
}
