import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 1/10/17.
 */
public class LoggingFilter implements ContainerRequestFilter{
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        List<String> list = new ArrayList<>();
        list.add("application/json");
        //list.add(MediaType.APPLICATION_JSON_TYPE);
        //requestContext.getAcceptableMediaTypes(list);

        //requestContext.getHeaders().put("Accept",list);
        System.out.println("Request Headers: "+requestContext.getHeaders());


    }
}
