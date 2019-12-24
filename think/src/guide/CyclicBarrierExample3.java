package guide;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample3 {
    private static final int threadCount = 550;
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5,()->{
        Random random = new Random();
        int c = random.nextInt(100);
        System.out.println("------当线程到达之后，有限执行-------" + c);
    });

    public static void main(String[] args) throws InterruptedException{
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for(int i = 0; i < threadCount; i++){
            final int threadNum = i;
            Thread.sleep(1000);
            threadPool.execute(() -> {
                try{
                    test(threadNum);
                }catch (InterruptedException | BrokenBarrierException e){
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
    }
    public static void test(int threadnum) throws InterruptedException,BrokenBarrierException{
        
        System.out.println("threadnum:" + threadnum + "is ready");
        cyclicBarrier.await();
        System.out.println("threadnum:" + threadnum + "is finish");
    }
}
