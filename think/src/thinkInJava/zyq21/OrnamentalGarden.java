package thinkInJava.zyq21;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//单个的count对象来跟踪花园参观者的主计数值
class Count {
    private int count = 0;
    private Random rand = new Random(47);
    //synchronized
    public synchronized  int increament() {
        int temp = count;
        //一半的机会上下文切换
        if(rand.nextBoolean()) {
            Thread.yield();
        }
        return (count = ++temp);
    }
    //synchronized
    public synchronized int value() {return count;}
}

class Entrance implements Runnable {
    //Count在Entance中当做静态域进行保存
    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<>();
    //维护本地值number
    private int number = 0;
    private final int id;
    private static volatile boolean canceled = false;
    public static void cancel() {
        canceled = true;
    }
    public Entrance(int id) {
        this.id = id;
        entrances.add(this);
    }

    public void run() {
        while(!canceled) {
            synchronized (this) {
                ++number;
            }
            System.out.println(this + " Total: " + count.increament());
            try{
                TimeUnit.MILLISECONDS.sleep(150);
            }catch (InterruptedException e) {
                System.out.println("sleep interrupted");
            }

        }
        System.out.println("Stopping " + this);
    }
    public synchronized int getValue() {
        return number;
    }
    public String toString() {
        return "Entrance " + id + ": " + getValue();
    }
    public static int getTotalCount() {
        return count.value();
    }
    public static int sumEntrances() {
        int sum = 0;
        for(Entrance entrance : entrances) {
            sum += entrance.getValue();
        }
        return sum;
    }
}

public class OrnamentalGarden {
    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++) {
            exec.execute(new Entrance(i));
        }
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        exec.shutdown();
        if(!exec.awaitTermination(250,TimeUnit.MILLISECONDS)){
            System.out.println("Some tasks were not terminated!");
        }
        System.out.println("Total: " + Entrance.getTotalCount());
        System.out.println("Sum of Entrances: " + Entrance.sumEntrances());
    }
}
