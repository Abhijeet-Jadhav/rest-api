//import lombok.extern.slf4j.Slf4j;

import model.TestService;

/**
 * Created by root on 1/9/17.
 */

public class Main {

    public static void main(String args[]){
        //Start REST server
        System.out.println("REST Server Started");
        TestService testService = new TestService(3);
        RESTServer.start(testService);

    }
}
