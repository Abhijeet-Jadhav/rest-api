import model.A;
import org.junit.Test;
import resourceImpl.MyResourceMockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertThat;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;

/**
 * Created by root on 1/19/17.
 */
public class getWeatherTest {
    @Test
    public void shouldGetIt() {
        A a = mock(A.class);
        when(a.getWeather()).thenReturn("sunny!");

        MyResourceMockito r = new MyResourceMockito(a);
        //assertThat(r.getIt(), is("sunny!"));
    }
}
