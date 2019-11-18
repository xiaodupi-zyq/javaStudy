package zyq21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Car {
    //唯一布尔属性，表示涂蜡-抛光状态
    private boolean waxOn = false;
    public synchronized  void waxed() {
        waxOn = true;
        notifyAll();
    }
    public synchronized void buffed() {
        waxOn = false;
        notifyAll();
    }
    //检查waxOn的标志
    public synchronized  void waitForWaxing() throws InterruptedException {
        while(waxOn == false)
            wait();
    }
    public synchronized void waitForBuffing() throws InterruptedException {
        while(waxOn == true) {
            wait();
        }
    }
}

class WaxOn implements Runnable {
    private Car car;
    public WaxOn (Car c) {
        car = c;
    }
    public void run(){
        try {
            while(!Thread.interrupted()) {
                System.out.println("Wax On! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        }catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax on task");
    }
}

class WaxOff implements Runnable {
    private Car car;
    public WaxOff (Car c) {
        car = c;
    }
    public void run(){
        try {
            while(!Thread.interrupted()) {
                car.waitForWaxing();
                System.out.println("Wax Off! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        }catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax off task");
    }
}

public class WaxOMatic {
    public static void main(String[] args) throws  Exception{
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }

}
