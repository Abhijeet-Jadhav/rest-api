package model;

/**
 * Created by root on 1/20/17.
 */
public class TestService {

    private int num ;

    public  TestService(int num){
        this.num = num;
    }

    public String printTest(){
        return "Test Service method printTest called! Passed num: "+num;
    }
}
