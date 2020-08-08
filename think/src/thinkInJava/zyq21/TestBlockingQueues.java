package thinkInJava.zyq21;

//class LiftOffRunner implements Runnable {
//    private BlockingQueue<LiftOff> rockets;
//    //构造函数
//    public LiftOffRunner(BlockingQueue<LiftOff> queue) {
//        rockets = queue;
//    }
//    public void add(LiftOff lo) {
//        try{
//            rockets.put(lo);
//        }catch (InterruptedException e){
//            System.out.println("Interrupted during put()");
//        }
//    }
//    public void run(){
//        try{
//            while(!Thread.interrupted()) {
//                LiftOff rocket = rockets.take();
//                rocket.run();
//            }
//        }catch (InterruptedException e){
//            System.out.println("Waking from take()");
//        }
//        System.out.println("Exiting LiftOffRunner");
//    }
//}

//public class TestBlockingQueues {
//    static void getkey() {
//        try {
//            new BufferedReader(new InputStreamReader(System.in)).readLine();
//        }catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    static void getkey(String message) {
//        System.out.println(message);
//        getkey();
//    }
//
//    static void  test(String msg,BlockingQueue<LiftOff> queue) {
//        System.out.println(msg);
//        LiftOffRunner runner = new LiftOffRunner(queue);
//        Thread t = new Thread(runner);
//        t.start();
//        for(int i = 0; i < 5; i++)
//            runner.add(new LiftOff(5));
//        getkey("Press 'Enter' (" + msg + ")");
//        t.interrupt();
//        System.out.println("Finished " + msg + " test");
//    }
//    public static void main(String[] args) {
//        test("LinkedBlockingQueue", // Unlimited size
//                new LinkedBlockingQueue<LiftOff>());
//        test("ArrayBlockingQueue", // Fixed size
//                new ArrayBlockingQueue<LiftOff>(3));
//        test("SynchronousQueue", // Size of 1
//                new SynchronousQueue<LiftOff>());
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class LiftOffRunner implements Runnable {
    private BlockingQueue<LiftOff> rockets;
    public LiftOffRunner(BlockingQueue<LiftOff> queue){
        rockets = queue;
    }
    public void add(LiftOff lo){
        try {
            rockets.put(lo);
        }catch (InterruptedException e){
            System.out.println("Interrupted during put()");
        }
    }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                LiftOff rocket = rockets.take();
                rocket.run();
            }
        }catch (InterruptedException e) {
            System.out.println("Waking from take()");
        }
        System.out.println("exiting LiftOffRunner");
    }
}

public class TestBlockingQueues {
    static void getKey() {
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    static void getKey(String message) {
        System.out.println(message);
        getKey();
    }
    static void test(String msg,BlockingQueue<LiftOff> queue){
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        for(int i = 0; i < 5; i++) {
            runner.add(new LiftOff(5));
        }
        getKey("Press 'Enter' (" + msg + " test");
        t.interrupt();
        System.out.println("Finished " + msg + " test");
    }
    public static void main(String[] args) {
        test("LinkedBlockingQueue", // Unlimited size
                new LinkedBlockingQueue<LiftOff>());
//        test("ArrayBlockingQueue", // Fixed size
//                new ArrayBlockingQueue<LiftOff>(3));
//        test("SynchronousQueue", // Size of 1
//                new SynchronousQueue<LiftOff>());
    }
}