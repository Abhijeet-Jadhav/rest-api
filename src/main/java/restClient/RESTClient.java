package restClient;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.OK;
import static org.junit.Assert.assertEquals;

/**
 * Created by root on 4/7/17.
 */
public class RESTClient {

    private static  Client client;
    private static WebTarget webTarget;
    private static String restServerURI;
    private static String resourceURl;

    public static void main(String ar[]) {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.register(JacksonJsonProvider.class);
        clientConfig.property("sun.net.http.allowRestrictedHeaders", "true");
        client = ClientBuilder.newClient(clientConfig);
        restServerURI = "http://localhost:9091/ping";
        System.out.println("REST Server URI: "+ restServerURI);

        webTarget = client.target(restServerURI);
        Invocation.Builder builder = webTarget.request();
        Response response = builder.get();
        assertEquals("Ping test", OK.getStatusCode(), response.getStatus());
        System.out.println("REST Server is running. Ping successful.");


        // TEST CreateScope POST http://controllerURI:Port/v1/scopes
        /*resourceURl = "http://localhost:9091/v1/scopes";
        webTarget = client.target(resourceURl);
        final ScopeProperty scopeProperty = new ScopeProperty();
        scopeProperty.setScopeName("scope1");
        builder = webTarget.request(MediaType.APPLICATION_JSON_TYPE);
        response = builder.post(Entity.json(scopeProperty));

        assertEquals("Create scope status", CREATED.getStatusCode(), response.getStatus());
        System.out.println("Scope created");*/

        resourceURl = "http://localhost:9091/v1/scopes/scope1/streams";
        webTarget = client.target(resourceURl);
        builder = webTarget.request(MediaType.APPLICATION_JSON_TYPE);
        ScalingConfig scalingConfig = new ScalingConfig();
        scalingConfig.setType(ScalingConfig.TypeEnum.FIXED_NUM_SEGMENTS);
        scalingConfig.setMinSegments(1);

        RetentionConfig retentionConfig = new RetentionConfig();
        retentionConfig.setType(RetentionConfig.TypeEnum.INFINITE);

        StreamProperty streamProperty = new StreamProperty();
        streamProperty.setScopeName("scope1");
        streamProperty.setStreamName("streamY");
        streamProperty.setScalingPolicy(scalingConfig);
        streamProperty.setRetentionPolicy(retentionConfig);

        /*builder = webTarget.request(MediaType.APPLICATION_JSON_TYPE);
        response = builder.post(Entity.json(streamProperty));*/

        /*assertEquals("Create stream status", 201, response.getStatus());
        System.out.println("StreamX created");*/

        StreamProperty[] streamProperties = new StreamProperty[100];
        for(int i=7; i< 100; i++){
            streamProperties[i] = new StreamProperty();
            streamProperties[i].setScopeName("scope1");
            streamProperties[i].setStreamName("Stream"+Integer.toString(i));
            streamProperties[i].setScalingPolicy(scalingConfig);
            streamProperties[i].setRetentionPolicy(retentionConfig);

            WebTarget webTarget1 = client.target(resourceURl);
            builder = webTarget1.request(MediaType.APPLICATION_JSON_TYPE);

            Response response1 = builder.post(Entity.json(streamProperties[i]));
            assertEquals("Stream name in response", "Stream"+Integer.toString(i),
                    response1.readEntity(StreamProperty.class).getStreamName());


            response1.close();
            System.out.println("done");
            //assertEquals("Create stream status", 201, response.getStatus());
        }
    }
}
