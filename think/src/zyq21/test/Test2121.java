package zyq21.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Ex {
    private boolean flag = false;
    public synchronized void change(){
        flag = true;
        notifyAll();//notifyAll notify wait在同步控制块中使用
    }
    public synchronized void waitForChange() throws InterruptedException {
        while(!flag){
            System.out.println("111");
            wait();
        }
        System.out.println("wait!!!");
    }
}

class ExTest1 implements Runnable{
    private Ex ex;
    ExTest1(Ex ex) {
        this.ex = ex;
    }
    public void run(){
        try{
            ex.waitForChange();
        }catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class ExTest2 implements Runnable{
    private Ex ex;
    ExTest2(Ex ex) {
        this.ex = ex;
    }
    public void run(){
        try{
            TimeUnit.SECONDS.sleep(2);
            System.out.println("change");
            TimeUnit.SECONDS.sleep(2);
            ex.change();
        }catch (InterruptedException e) {
            System.out.println(e);
        }

    }
}

public class Test2121 {
    public static void main(String[] args) throws  Exception{
        Ex ex = new Ex();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExTest1(ex));
        exec.execute(new ExTest2(ex));
        TimeUnit.SECONDS.sleep(8);
        exec.shutdownNow();
    }
}

