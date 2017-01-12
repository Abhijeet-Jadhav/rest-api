package resourceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by root on 1/12/17.
 */
@Path("/")
@Produces(MediaType.TEXT_PLAIN)

public class SubResourceImpl {

    @GET // http://localhost:9797/home/subresource/asd?username=abhi
    public String getAllComments(@PathParam("subResource") String subResource, @QueryParam("username") String name) {
        return "sub resource class "+subResource+" name"+name;
    }
    //
}
