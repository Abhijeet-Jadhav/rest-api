import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import java.io.IOException;
import org.glassfish.jersey.internal.util.Base64;

import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by root on 1/10/17.
 */
public class SecurityFilter implements ContainerRequestFilter {

    private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
    private static final String AUTHORIZATION_HEADER_BASIC = "Basic ";
    private static final String SECURED_URL_PREFIX = "secured";




    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        if (requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {

            List<String> authHeaderlist = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);

            if (authHeaderlist != null && authHeaderlist.size() > 0) {
                String authToken = authHeaderlist.get(0);
                authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_BASIC, "");
                String decodedString = Base64.decodeAsString(authToken);
                StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
                String username = tokenizer.nextToken();
                String password = tokenizer.nextToken();

                if ("user".equals(username) && "pass".equals(password)) {
                    return;
                }

            }

            Response unauthorizedStatuts = Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity("user cannot access this entity")
                    .build();

            requestContext.abortWith(unauthorizedStatuts);
        }

    }
}
