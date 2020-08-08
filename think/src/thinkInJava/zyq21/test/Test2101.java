package thinkInJava.zyq21.test;

import thinkInJava.zyq21.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test2101 implements Runnable{
    public static int id = 0;
    public final int count = id++;
    @Override
    public void run() {
        System.out.println("id: " + id + " start");
        for(int i = 0; i < 3; i++){
            System.out.println("id: " + i);
            Thread.yield();
        }
        System.out.println("id: " + id + " end");

    }
}

class ThreadDemo {
    public static void main(String[] args){
        for(int i = 0 ; i < 3; i++){
            new Thread(new Test2101()).start();
        }
    }
}

class ThreadTest2103 {
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0 ; i < 3; i++){
//            new Thread(new Test2101()).start();
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
class ThreadTest2104 {
    public static void main(String[] args){
        ExecutorService exec = Executors.newFixedThreadPool(3);
        for(int i = 0 ; i < 3; i++){
//            new Thread(new Test2101()).start();
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}

class ThreadTest2105 {
    public static void main(String[] args){
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for(int i = 0 ; i < 3; i++){
//            new Thread(new Test2101()).start();
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}