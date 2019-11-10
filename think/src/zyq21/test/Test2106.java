package zyq21.test;

import zyq21.LiftOff;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test2106 extends LiftOff {
    public void run() {
        try{
            while(countDown-- > 0){
                System.out.print(status());
                Random random = new Random(47);
                TimeUnit.MILLISECONDS.sleep(random.nextInt(10));
//                System.out.print(" sleeping " + random.nextInt(10) + " ; ");
            }
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
    }
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++){
            exec.execute(new Test2106());
        }
        exec.shutdown();
    }
}

