package zyq21;

public class SynchronizedEvenGenerator extends IntGenerator{
    private int currentEvenValue = 0;
    public synchronized int next() { //synchronized加锁
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }
    public static  void main(String[] args){
        EvenChecker.test(new SynchronizedEvenGenerator());
    }

}
