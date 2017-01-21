package resourceImpl;

import model.A;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by root on 1/19/17.
 */
@Path("/myresource")
public class MyResourceMockito {

    private A a;

    public MyResourceMockito(A a) {
        this.a = a;
    }

    @GET
    @Produces("text/plain")
    public String getIt() {
        return a.getWeather();
    }
}
