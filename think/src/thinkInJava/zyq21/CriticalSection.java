package thinkInJava.zyq21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

//线程不安全的，约束条件要求两个变量为相同的值
class Pair {
    private int x,y;
    public Pair (int x,int y) {
        this.x = x;
        this.y = y;
    }
    public Pair() {this(0,0);}
    public int getX() {return x;}
    public int getY() {return y;}
    public void incrementX() {x++;}
    public void incrementY() {y++;}
    public String toString() {
        return "x: " + x + ", y: " + y;
    }
    public class PairValuesNotEqualException extends RuntimeException {
        public PairValuesNotEqualException() {
            super("Pair values not equal: " + Pair.this);
        }
    }
    public void checkState() {
        if(x != y){
            throw new PairValuesNotEqualException();
        }
    }
}

//对Pair对象的安全访问进行控制
abstract class PairManager {
    AtomicInteger checkCounter = new AtomicInteger(0);
    //持有一个Pair对象，对Pair的访问进行管理
    protected Pair p = new Pair();
    //synchronizedList操作时线程安全的List
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<>());
    //唯一的public方法，是synchronized的
    public synchronized Pair getPair() {
        return new Pair(p.getX(),p.getY());
    }
    protected void store(Pair p) {
        storage.add(p);
        try{
            TimeUnit.MILLISECONDS.sleep(50);
        }catch (InterruptedException ignore) {}
    }
    //抽象方法同步控制，在实现的时候进行控制
    public abstract void increment();
}

class PairManager1 extends PairManager {
    //实现抽象类abstarct PairManager的安全访问，整个方法是被同步控制的
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}

class PairManager2 extends PairManager {
    public void increment() {
        Pair temp;
        //实现抽象类abstarct PairManager的安全访问，使用同步控制块进行同步
        synchronized (this) {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }
        //store操作线程安全，可以在代码块外面
        store(temp);
    }
}

//创建用于测试两种不同类型的PairManager，在某个任务中调用increment()
class PairManipulator implements Runnable {
    private PairManager pm;
    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }
    public void run() {
        while(true) {
            pm.increment();
        }
    }
    public String toString() {
        return "Pair: " + pm.getPair() + " CheckCounter = " + pm.checkCounter.get();
    }
}

//在另一个任务中执行，
class PairChecker implements Runnable {
    private PairManager pm;
    public PairChecker(PairManager pm) {
        this.pm = pm;
    }
    public void run() {
        while(true) {
            pm.checkCounter.incrementAndGet();
            pm.getPair().checkState();
        }
    }
}

public class CriticalSection {
    // Test the two different approaches:
    static void testApproaches(PairManager pman1, PairManager pman2) {
        ExecutorService exec = Executors.newCachedThreadPool();
        PairManipulator
                pm1 = new PairManipulator(pman1),
                pm2 = new PairManipulator(pman2);
        PairChecker
                pcheck1 = new PairChecker(pman1),
                pcheck2 = new PairChecker(pman2);
        exec.execute(pm1);
        exec.execute(pm2);
        exec.execute(pcheck1);
        exec.execute(pcheck2);
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch(InterruptedException e) {
            System.out.println("Sleep interrupted");
        }
        System.out.println("pm1: " + pm1 + "\npm2: " + pm2);
        System.exit(0);
    }
    public static void main(String[] args) {
        PairManager
                pman1 = new PairManager1(),
                pman2 = new PairManager2();
        testApproaches(pman1, pman2);
    }
}
