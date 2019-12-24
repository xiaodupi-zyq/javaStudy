package guide;

import java.util.concurrent.*;

public class CyclicBarrierExample2 {
    private static final int threadCount = 550;
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) throws  InterruptedException{
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for(int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            threadPool.execute(() -> {
                try {
                    test(threadNum);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }catch (BrokenBarrierException e){
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
    }

    public static void test(int threadnum) throws InterruptedException,BrokenBarrierException{
        System.out.println("threadnum: " + threadnum + " is ready");
        try {
            /**等待60秒，保证子线程完全执行结束*/
            cyclicBarrier.await();
        } catch (Exception e) {
            System.out.println("-----CyclicBarrierException------");
        }
        System.out.println("threadnum: " + threadnum + " is finish");
    }

}
