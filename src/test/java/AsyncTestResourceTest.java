import model.TestService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;
import resourceImpl.AsyncTestResource;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by root on 1/21/17.
 */
public class AsyncTestResourceTest extends JerseyTest {

    TestService mockTestService;
    AsyncTestResource mockAsyncTestResource;
    CompletableFuture<String> comStr;

    @Before
    public void setup() {

        comStr = CompletableFuture.completedFuture("woke up");
    }

    @Override
    protected Application configure() {
        mockTestService = mock(TestService.class);
        mockAsyncTestResource = new AsyncTestResource(mockTestService); // registered resource has to instantiated in configure
        return new ResourceConfig().register(mockAsyncTestResource).register(new AbstractBinder() {
            @Override
            protected void configure() {
                bindFactory(new InstanceFactory<TestService>(mockTestService)).to(TestService.class);
            }
        }).register(mockAsyncTestResource);
    }

    @Test
    public void test() {
        when(mockTestService.sleepTestFuture()).thenReturn(comStr);
        final Response response = target("/async/test/print/abc").request().get(Response.class);
        assertEquals("woke up", response.readEntity(String.class));
    }
}
