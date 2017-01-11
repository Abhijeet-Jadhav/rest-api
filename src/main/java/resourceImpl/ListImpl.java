package resourceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by root on 1/10/17.
 */
@Path("/list")
@Provider
public class ListImpl {

    // localhost:9797/list/names?limit=4&offset=4  -- return [e , f , g , h ]
    // http://localhost:9797/list/names?limit=4&offset=0    [a , b , c , d ]

    @GET
    @Path("/names")
    @Produces(MediaType.TEXT_PLAIN)
    public String listNames(@QueryParam("limit") String limit, @QueryParam("offset") String offset){
        List<String> list = Arrays.asList("a "," b"," c","d ","e ","f ","g ","h ","i ",
                "j ","k ","l ","m ","n ","o ","p ","q ","r ","s ","t ","u ","v ","w ","x ","y ", "z ");
        List<String> sublist = list.subList(Integer.parseInt(offset), Integer.parseInt(offset)+Integer.parseInt(limit) );
        //return Response.ok(sublist).status(200).build();
        return sublist.toString();
    }
}
