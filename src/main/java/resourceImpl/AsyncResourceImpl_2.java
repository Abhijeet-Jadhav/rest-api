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
    public void asyncGet(@Suspended final AsyncResponse asyncResponse) {
        executor.execute(() -> {
            String result = service.veryExpensiveOperation();
            asyncResponse.resume(result);
        });
    }*/

    @GET
    @ManagedAsync
    @Path("/get/{num}")
    @Produces(MediaType.TEXT_PLAIN)
    public void asyncGet(@Suspended final AsyncResponse asyncResponse, @PathParam("num") int taskNum) {

        System.out.println("taskNum="+taskNum+"  Request handled by thread "+Thread.currentThread().getId());
        String result = veryExpensiveOperation(taskNum);
        System.out.println("taskNum="+taskNum+"  Response handled by thread "+Thread.currentThread().getId());
        asyncResponse.resume(result);
    }

    public static String veryExpensiveOperation(int taskNum){
        try {
            Thread.sleep(10000); //10 sec
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
}
