package resourceImpl;

import io.swagger.annotations.Api;
import model.SampleRequest;
import model.SampleResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 * Created by root on 12/18/16.
 */
@Api
@Path("/home")
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

    // http://localhost:9797/home/wrapper
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("wrapper")
    public Response getWrapper()
    {
        return Response.ok(new Object(){ public String data = "hello world";}).build();
    }

    @GET
    @Path("context")  // http://localhost:9797/home/context
    @Produces(MediaType.TEXT_PLAIN)
    public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
        return "Absolute path " +uriInfo.getAbsolutePath()
                +"\n query params"+uriInfo.getQueryParameters()
                +"\nHeaders "+httpHeaders.getRequestHeaders()
                +"\n cookies "+httpHeaders.getCookies();
    }


    @POST
    @Path("pojo/{num}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response jsonToPojo(SampleRequest sampleRequest, @PathParam("num") String num){
        SampleResponse sampleResponse = new SampleResponse();
        sampleResponse.setText("num "+num+" "+"first name= "+sampleRequest.getFirstName()+" last name "+sampleRequest.getLastName()+" age="+sampleRequest.getAge());
        return Response.ok(sampleResponse).build();
    }
    // POST at http://localhost:9797/home/pojo
    // { "firstName": "abc", "lastName": "def", "age": 50}


    @Path("/subresource/{subResource}")
    public SubResourceImpl getCommentResource() {
        return new SubResourceImpl();
    }
}
