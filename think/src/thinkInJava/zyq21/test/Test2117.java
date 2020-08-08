package thinkInJava.zyq21.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test2117 {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 3; i++){
            exec.execute(new Sensor(i));
        }
        TimeUnit.SECONDS.sleep(2);
        Sensor.Cancel();
        exec.shutdown();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Sum of Sensor: " + Sensor.sum());
    }
}

class RadCount {
    private int count = 0;
    private Random random = new Random(47);

    public synchronized int increment(){
        int temp = ++count;
        if(random.nextBoolean()) {
            Thread.yield();
        }
        return temp;
    }

    public synchronized int getCount() {return count;}
}

class Sensor implements Runnable{
    private static RadCount radCount = new RadCount();
    private int number = 0;
    private final int id;
    private static volatile boolean canceled = false;
    private static List<Sensor> sensors = new ArrayList<>();
    public Sensor(int id){
        this.id = id;
        sensors.add(this);
    }
    public static void Cancel() {
        canceled = true;
    }

    public void run(){
        while(!canceled) {
            synchronized (this) {
                ++number;
            }
            System.out.println(this + " Total: " + radCount.increment());
            try{
                TimeUnit.MILLISECONDS.sleep(100);
            }catch (Exception e){
                System.out.println(e);
            }
        }
        System.out.println("Stopping " +this);
    }
    public synchronized int getValue() {
        return number;
    }
    public String toString() {
        return "Sensor " + id + ": " + getValue();
    }
    public static int getTotalCount() {
        return radCount.getCount();
    }
    public static int sum() {
        int Sum = 0;
        for(Sensor sensor : sensors) {
            Sum += sensor.number;
        }
        return Sum;
    }
}

