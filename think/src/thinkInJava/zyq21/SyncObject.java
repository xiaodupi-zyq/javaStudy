package thinkInJava.zyq21;

class DualSynch{
    private Object syncObject = new Object();
    //通过同步整个方法，在this上同步
    public synchronized void f() {
        for(int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }
    //f()和g()两个同步是互相独立的，
    public void g(){
        //一个在syncObject上同步的synchronized块
        synchronized (syncObject) {
            for(int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}

public class SyncObject {
    public static void main(String[] args){
        final DualSynch ds = new DualSynch();
        new Thread() {
            public void run(){
                ds.f();
            }
        }.start();
        ds.g();
    }
}


