package dezso.varga.teamgenerator.rest.resources;

import dezso.varga.teamgenerator.common.exceptions.PlayerNotFoundException;
import dezso.varga.teamgenerator.domain.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


/**
 * Created by varga on 24.10.2015.
 */
@Provider
public class PlayerNotFoundExceptionMapper implements ExceptionMapper<PlayerNotFoundException> {

    @Override
    public Response toResponse(PlayerNotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 404, "link to docs");
        return Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
    }
}
