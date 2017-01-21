package resourceImpl;

import model.TestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by root on 1/21/17.
 */
@Path("/async/test/")
public class AsyncTestResource {

    private final TestService testService;

    public AsyncTestResource(TestService testService) {
        this.testService = testService;
    }

    @GET
    @Path("/print/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public void asyncTestPrint(@PathParam("name") String name, @Suspended final AsyncResponse asyncResponse) throws InterruptedException {
        System.out.println("Request handling operation done by thread " + Thread.currentThread().getId());
        CompletableFuture.supplyAsync(() -> testService.sleepTestFuture())
                .thenApply(str -> {
                    if (str != null)
                        try {
                            return Response.status(200).entity(str.get()).build();
                        } catch (InterruptedException | ExecutionException e) {
                            e.printStackTrace();
                        }
                    else
                        return Response.status(404).entity("Not found").build();
                    return Response.status(500).entity("Internal server error").build();

                }).thenApply(result -> asyncResponse.resume(result));

        System.out.println("Request operation RETURNED by thread " + Thread.currentThread().getId());
    }
    //GET  localhost:9797/async/test/print/abc

}
