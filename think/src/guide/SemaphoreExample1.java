package guide;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample1 {
//    请求的数量
    private static final int threadCount = 550;

    public static void main(String[] args) throws InterruptedException {
//        创建一个具有固定线程数量的线程池对象（如果这里线程池数量给太少的话，你会发现执行的很慢。
        ExecutorService threadPool = Executors.newFixedThreadPool(300);
//        一次只能允许执行的线程数量
        final Semaphore semaphore = new Semaphore(20);

        for(int i = 0;i < threadCount; i++){
            final int threadnum = i;
            threadPool.execute(()->{
                try {
                    semaphore.acquire();//获取一个许可，所以可运行的数量为20/1=20
                    test(threadnum);
                    semaphore.release();//释放一个许可
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
        System.out.println("finish");
    }
    public static void test(int threadnum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("threadnum: " + threadnum);
        Thread.sleep(1000);
    }
}
