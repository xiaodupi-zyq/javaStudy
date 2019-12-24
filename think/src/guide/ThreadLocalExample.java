package guide;

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalExample implements Runnable{
    //SimpleDateFormat不是线程安全的，所以每个线程都要有自己的独立副本
    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(()-> new SimpleDateFormat("yyyyMMdd HHmm"));

    public static void main(String[] args) throws InterruptedException{
        ThreadLocalExample obj = new ThreadLocalExample();
        for(int i = 0;i < 10;i++){
            Thread t = new Thread(obj,""+i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Thread Name="+Thread.currentThread().getName()+" default Formatter = " + formatter.get().toPattern());
        try{
            Thread.sleep(new Random().nextInt(1000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        formatter.set(new SimpleDateFormat());

        System.out.println("Thread Name= "+Thread.currentThread().getName()+" formatter = "+formatter.get().toPattern());
    }
}
