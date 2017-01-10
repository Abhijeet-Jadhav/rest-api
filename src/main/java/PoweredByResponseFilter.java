import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by root on 1/9/17.
 */


@Provider
public class PoweredByResponseFilter implements ContainerResponseFilter {

    // Add something before sending every response
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        responseContext.getHeaders().add("PoweredBy","GitHub");
    }
}
