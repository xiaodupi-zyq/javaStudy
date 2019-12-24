package guide;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    public static void main(String[] args){
        int temValue = 0;
        AtomicInteger i = new AtomicInteger(0);
        temValue = i.getAndSet(3);
        System.out.println("temValue: " + temValue + "; i:" + i);
        temValue = i.getAndIncrement();
        System.out.println("temValue: " + temValue + "; i:" + i);
        temValue = i.getAndAdd(5);
        System.out.println("temValue: " + temValue + "; i:" + i);
    }
}
