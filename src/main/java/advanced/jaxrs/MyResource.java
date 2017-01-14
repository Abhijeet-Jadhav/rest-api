package advanced.jaxrs;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by root on 1/13/17.
 */
@Path("test/{path}")
public class MyResource {
    private int count ;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String testMethod() {

        // for singletons understanding
        // count = count + 1;
        //return "It works! count="+count;
        //return "QueryParam "+queryParam+" PathParam = "+pathParam;
        return "asd";
    }
}
