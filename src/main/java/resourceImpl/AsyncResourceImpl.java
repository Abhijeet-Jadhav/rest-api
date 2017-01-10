package resourceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

/**
 * Created by root on 1/9/17.
 */
@Path("/resource/{task_name}")
public class AsyncResourceImpl {
    @GET
    public void asyncGet(@Suspended final AsyncResponse asyncResponse, @PathParam("task_name") String task_name) {
        long threadIdMain = Thread.currentThread().getId();
        System.out.println("asyncGet Thread # " + threadIdMain + " is doing this task "+task_name);

        new Thread(new Runnable() {
            @Override
            public void run() {
                long threadId = Thread.currentThread().getId();
                System.out.println("run Thread # " + threadId + " is doing this task");
                String result = veryExpensiveOperation();
                asyncResponse.resume(result);
            }

            private String veryExpensiveOperation() {
                // ... very expensive operation
                long threadIdOperation = Thread.currentThread().getId();
                try {
                    Thread.sleep(15000); //15 sec
                    System.out.println("Expensive operation done by thread "+threadIdOperation);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return task_name+" done processing by thread "+threadIdOperation;
            }
        }).start();

        long threadIdReturn = Thread.currentThread().getId();
        System.out.println("Returning: Thread # " + threadIdReturn + " is doing this task "+task_name);
    }
}
