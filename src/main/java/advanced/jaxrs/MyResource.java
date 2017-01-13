package advanced.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by root on 1/13/17.
 */
@Path("test")
public class MyResource {
    private int count ;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String testMethod() {
        count = count + 1;
        return "It works! count="+count;
    }
}
