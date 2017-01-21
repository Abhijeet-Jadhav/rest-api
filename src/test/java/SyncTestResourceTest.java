import model.TestService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import resourceImpl.TestResource;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by root on 1/21/17.
 */
public class SyncTestResourceTest extends JerseyTest{

    TestService mockTestService;
    TestResource testResource;

    @Override
    protected Application configure() {
        mockTestService = mock(TestService.class);
        testResource = new TestResource(mockTestService);

        when(mockTestService.printTest()).thenReturn("TestResource testPrint Name :abc");
        //return new ResourceConfig(TestResource.class);

        return new ResourceConfig().register(testResource).register(new AbstractBinder() {
            @Override
            protected void configure() {
                bindFactory(new InstanceFactory<TestService>(mockTestService)).to(TestService.class);
            }
        }).register(testResource);
    }

    @Test
    public void test() {
        final Response response = target("/test/print/abc").request().get(Response.class);
        assertEquals("TestResource testPrint Name :abc", response.readEntity(String.class));
    }

}
