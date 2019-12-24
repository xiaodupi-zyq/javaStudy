package guide;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDefectDemo {
    public static void main(String[] args){
        defectOfABA();
    }
    static void defectOfABA(){
        final AtomicInteger atomicInteger = new AtomicInteger(1);

        Thread coreThread = new Thread(
                ()-> {
                    final int currentValue = atomicInteger.get();
                    System.out.println(Thread.currentThread().getName() + " -------------currentVakue = " + currentValue );
                    //模拟其他处理业务花费时间
                    try{
                        Thread.sleep(300);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                    boolean casResult = atomicInteger.compareAndSet(1,2);
                    System.out.println(Thread.currentThread().getName() + " ------ currentValue=" + currentValue + ", finalValue=" + atomicInteger.get() + ", compareAndSet Result=" + casResult);
                }
        );
        coreThread.start();

        Thread amateurThread = new Thread(
                () -> {
                    int currentValue = atomicInteger.get();
                    boolean casResult = atomicInteger.compareAndSet(1,2);
                    System.out.println(Thread.currentThread().getName()
                            + " ------ currentValue=" + currentValue
                            + ", finalValue=" + atomicInteger.get()
                            + ", compareAndSet Result=" + casResult);
                    currentValue = atomicInteger.get();
                    casResult = atomicInteger.compareAndSet(2,1);
                    System.out.println(Thread.currentThread().getName()
                            + " ------ currentValue=" + currentValue
                            + ", finalValue=" + atomicInteger.get()
                            + ", compareAndSet Result=" + casResult);
                }
        );
        amateurThread.start();

    }
}
