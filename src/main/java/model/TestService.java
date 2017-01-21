package model;

import java.util.concurrent.CompletableFuture;

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

    public String sleepTest()  {
        System.out.println("Sleep operation done by thread "+Thread.currentThread().getId());
        try {
            Thread.sleep(5000); // 5 sec
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "woke up";
    }


    public CompletableFuture<String> sleepTestFuture()  {
        System.out.println("Sleep operation done by thread "+Thread.currentThread().getId());
        try {
            Thread.sleep(5000); // 5 sec
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String awake = "woke up";
        System.out.println("Sleep operation RETURNED by thread "+Thread.currentThread().getId());
        return CompletableFuture.supplyAsync(() -> awake);
    }
}
