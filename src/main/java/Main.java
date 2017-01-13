import lombok.extern.slf4j.Slf4j;

/**
 * Created by root on 1/9/17.
 */
@Slf4j
public class Main {

    public static void main(String args[]){
        //Start REST server
        System.out.println("Starting REST Server");
        RESTServer.start();
    }
}
