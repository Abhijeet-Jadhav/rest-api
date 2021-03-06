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
        responseContext.getHeaders().add("PoweredBy","*");
        responseContext.getHeaders().add("Access-Control-Allow-Origin","*");
        responseContext.getHeaders().add("Access-Control-Allow-Methods","POST, GET, DELETE, PUT, OPTIONS");
        responseContext.getHeaders().add("Access-Control-Allow-Headers","Content-Type, api_key, Authorization, x-requested-with, Total-Count, Total-Pages, Error-Message");
        responseContext.getHeaders().add("Access-Control-Max-Age","1800");

        /*
        Access-Control-Allow-Origin: *
        Access-Control-Allow-Methods: POST, GET, DELETE, PUT, OPTIONS
        Access-Control-Allow-Headers: Content-Type, api_key, Authorization, x-requested-with, Total-Count, Total-Pages, Error-Message
        Access-Control-Max-Age: 1800
        */
    }
}
