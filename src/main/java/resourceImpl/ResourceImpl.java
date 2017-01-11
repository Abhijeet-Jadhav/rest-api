package resourceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by root on 12/18/16.
 */
@Path("home")
public class ResourceImpl {

    @GET
    @Path("hello")
    @Produces(MediaType.APPLICATION_JSON)
    public String helloWorld() {
        return "Hello, world!";
    }
    //curl -i -H "Accept: application/json" "localhost:2222/home/hello"

    @GET
    @Path("param")
    @Produces(MediaType.APPLICATION_JSON)
    public String queryParamMethod(@QueryParam("name") String name, @QueryParam("lastname") String lastname) {
        return "Hello, " + name + " "+ lastname;
    }
    // http://localhost:9797/home/param?name=abhi&lastname=jadhav

    @GET
    @Path("path/{var}")
    @Produces(MediaType.APPLICATION_JSON)
    public String pathMethod(@PathParam("var") String name) {
        return "Hello, " + name;
    }
    // http://localhost:9797/home/path/abhi

    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String postMethod(@FormParam("name") String name) {
        return "<h2>Hello, " + name + "</h2>";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("wrapper")
    public Response getWrapper()
    {
        return Response.ok(new Object(){ public String data = "hello world";}).build();
    }

}
