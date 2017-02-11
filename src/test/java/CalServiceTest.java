import mockito.java.example1.CalService;
import mockito.java.example1.ICalculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by root on 1/20/17.
 */
public class CalServiceTest {
    CalService calService;

    @Before
    public void setup(){
        calService = new CalService();

        ICalculator cal = mock(ICalculator.class);
        when(cal.add(3,4)).thenReturn(7);
        calService.setCal(cal);

    }

    @Test
    public void testAdd(){
        Assert.assertEquals("cal test: ",7,calService.addTwoNums(3,4) );
    }
}
