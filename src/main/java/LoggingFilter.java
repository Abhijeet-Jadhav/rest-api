import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import java.io.IOException;

/**
 * Created by root on 1/10/17.
 */
public class LoggingFilter implements ContainerRequestFilter{
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        System.out.println("Request Headers: "+requestContext.getHeaders());
    }
}
