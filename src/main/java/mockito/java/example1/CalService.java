package mockito.java.example1;

/**
 * Created by root on 1/20/17.
 */
public class CalService {

    ICalculator cal;

    public ICalculator getCal() {
        return cal;
    }

    public void setCal(ICalculator cal) {
        this.cal = cal;
    }

    public int addTwoNums(int x, int y){
        return cal.add(x,y);
    }

}
