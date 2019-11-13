package zyq21.test;

import java.util.concurrent.locks.ReentrantLock;

import static util.Print.print;

public class Test2115 {
}

class SyncTest1 {
    ReentrantLock lock = new ReentrantLock();
    public void f1() {
        lock.lock();
        try{
            for(int i = 0; i < 5; i++) {
                print("f1()");
                Thread.yield();
            }
        }finally {
            lock.unlock();
        }
    }
    public void g1() {
        lock.lock();
        try{
            for(int i = 0; i < 5; i++) {
                print("g1()");
                Thread.yield();
            }
        }finally {
            lock.unlock();
        }
    }
    public void h1() {
        lock.lock();
        try{
            for(int i = 0; i < 5; i++) {
                print("h1()");
                Thread.yield();
            }
        }finally {
            lock.unlock();
        }
    }
}

class SyncTest2 {
    private Object syncObject1 = new Object();
    private Object syncObject2 = new Object();
    private Object syncObject3 = new Object();
    public void f2() {
        synchronized(syncObject1) {
            for(int i = 0; i < 5; i++) {
                print("f2()");
                Thread.yield();
            }
        }
    }
    public void g2() {
        synchronized(syncObject2) {
            for(int i = 0; i < 5; i++) {
                print("g2()");
                Thread.yield();
            }
        }
    }
    public void h2() {
        synchronized(syncObject3) {
            for(int i = 0; i < 5; i++) {
                print("h2()");
                Thread.yield();
            }
        }
    }
}

class Ex15 {
    public static void main(String[] args) {
        final SyncTest1 st1 = new SyncTest1();
        final SyncTest2 st2 = new SyncTest2();
        new Thread() {
            public void run() {
                st1.f1();
            }
        }.start();
        new Thread() {
            public void run() {
                st1.g1();
            }
        }.start();
        new Thread() {
            public void run() {
                st1.h1();
            }
        }.start();
/*
        new Thread() {
            public void run() {
                st2.f2();
            }
        }.start();
        new Thread() {
            public void run() {
                st2.g2();
            }
        }.start();
        new Thread() {
            public void run() {
                st2.h2();
            }
        }.start();
*/
    }
}
