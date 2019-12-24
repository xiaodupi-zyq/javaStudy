package guide;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class MyRunnable implements Runnable{
    private String command;

    public MyRunnable(String s){
        command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "start Time: " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + "end Time: " + new Date());
    }

    private void processCommand() {
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return this.command;
    }
}

public class ThreadPoolExecutorDemo {
    //corePoolSize核心线程数5
    private static final int CORE_POOL_SIZE = 5;
//    maximumPoolSize最大线程数为10
    private static final int MAX_POOL_SIZE = 10;
//    workQueue：任务队列为 ArrayBlockingQueue，并且容量为 100;
    private static final int QUEUE_CAPACITY = 100;
//    keepAliveTime : 等待时间为 1L。
    private static final Long KEEP_ALIVE_TIME = 1L;
    public static void main(String[] args){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE,MAX_POOL_SIZE,KEEP_ALIVE_TIME, TimeUnit.SECONDS,new ArrayBlockingQueue<>(QUEUE_CAPACITY),new ThreadPoolExecutor.CallerRunsPolicy());

        for(int i = 0; i < 12; i++){
            //创建WorkerThread对象
            Runnable worker = new MyRunnable("" + i);
            executor.execute(worker);
        }
        //终止线程池
        executor.shutdown();
        while(!executor.isTerminated()){

        }
        System.out.println("Finished all threads");
    }
}
