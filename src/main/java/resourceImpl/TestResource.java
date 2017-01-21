package resourceImpl;

import model.TestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Created by root on 1/20/17.
 */

@Path("/test")
public class TestResource {

    private final TestService testService;

    public TestResource(TestService testService) {
        this.testService = testService;
    }

    @Path("/print/{name}")
    @GET
    public Response testPrint(@PathParam("name") String name) {
        testService.printTest();
        System.out.println("Inside TestResource class /test/print/{name}\n");
        return Response.ok(testService.printTest()).entity("TestResource testPrint Name :"+name).build();
    }
    // localhost:9797/test/print/abc

}
