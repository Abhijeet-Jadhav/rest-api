package resourceImpl;

import org.glassfish.jersey.server.ManagedAsync;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

/**
 * Created by root on 1/16/17.
 */

// Asynchronous REST Services with JAX-RS and CompletableFuture

@Path("/async")
public class AsyncResourceImpl_2 {


    /*@Inject
    private Executor executor;
    @GET
    @Path("/executor/{num}")
    public void asyncGetExecutor(@Suspended final AsyncResponse asyncResponse, @PathParam("num") int taskNum) {
        System.out.println("taskNum="+taskNum+"  Request handled by thread "+Thread.currentThread().getId());

        executor.execute(() -> {
            String result = veryExpensiveOperation(taskNum);
            asyncResponse.resume(result);
        });
        System.out.println("taskNum="+taskNum+"  Response handled by thread "+Thread.currentThread().getId());
    }*/

    @GET
    @Path("/get123/{num}") // localhost:9797/async/get123/1
    @Produces(MediaType.TEXT_PLAIN)
    @ManagedAsync
    public void asyncGet123(@Suspended final AsyncResponse asyncResponse, @PathParam("num") int taskNum) {

        System.out.println("taskNum="+taskNum+"  Request handled by thread "+Thread.currentThread().getId());
        String result = veryExpensiveOperation(taskNum);
        System.out.println("taskNum="+taskNum+"  Response handled by thread "+Thread.currentThread().getId());
        asyncResponse.resume(result);
    }

    @GET
    @Path("/get/{num}")
    @Produces(MediaType.TEXT_PLAIN)
    //@ManagedAsync
    public void asyncGet(@Suspended final AsyncResponse asyncResponse, @PathParam("num") int taskNum) {
        System.out.println("taskNum="+taskNum+"  Request handled by thread "+Thread.currentThread().getId());
        CompletableFuture
                .runAsync(() -> veryExpensiveOperation(taskNum))
                .thenApply((result) -> asyncResponse.resume(result));

    }
    public static String veryExpensiveOperation(int taskNum){
        try {
            Thread.sleep(5000); //5 sec
            System.out.println("taskNum="+taskNum+"Expensive operation done by thread "+Thread.currentThread().getId());
        } catch (InterruptedException e) {
            System.out.println("InterruptedException occurred");
            e.printStackTrace();
        } finally {
            System.out.println("taskNum="+taskNum+"Response returned by thread "+Thread.currentThread().getId());
            System.out.println();
            return "Done processing request";
        }
    }

    /*CompletableFuture.supplyAsync(() -> )
            .thenApply( (response1) ->  asyncResponse.resume(createStreamStatus.thenApply(x -> {
        if(x == CreateStreamStatus.SUCCESS )
            return Response.ok(streamConfiguration).status(201).build();
        else if(x == CreateStreamStatus.STREAM_EXISTS)
            return Response.status(409).build();
        else
            return Response.status(500).build();
    }))
            );*/
}
