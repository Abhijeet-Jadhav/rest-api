package resourceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by root on 1/10/17.
 */
@Path("/secured")
public class SecuredResource {

    @GET
    @Path("/message")
    @Produces(MediaType.TEXT_PLAIN)
    public String securedMethod(){
        return "This API is secured. ";
    }
    // localhost:9797/secured/message
}
