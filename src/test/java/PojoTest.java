import model.SampleRequest;
import model.SampleResponse;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;
import resourceImpl.ResourceImpl;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by root on 1/20/17.
 */
public class PojoTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(ResourceImpl.class);
    }

    SampleResponse sampleResponse;
    SampleRequest sampleRequest;

    @Before
    public void setup() {
        sampleResponse = new SampleResponse();
        sampleRequest = new SampleRequest();

        sampleRequest.setFirstName("abc");
        sampleRequest.setLastName("def");
        sampleRequest.setAge(50);
        sampleResponse.setText("num 1 first name= abc last name def age=50");
    }

    @Test
    public void test() {
        SampleResponse mockSampleResponse = mock(SampleResponse.class);
        //when(mockSampleResponse.setText( ).thenReturn()
        //final Response response = target("/home/pojo/1").request().get(Response.class);
        //assertEquals(sampleResponse, response);
    }
}
