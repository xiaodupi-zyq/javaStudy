package designPattern.structure;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 20:45 2020/8/6
 * @Modified By:
 */

/**
 * 双重校验式，线程安全
 */
public class Singleton {
    //防止指令重排，在多线程中没有实例化的对象被返回，这样照成对象的多线程问题
    private volatile static Singleton uniqueInstance;

    private Singleton(){}

    public static Singleton getUniqueInstance(){
        /**
         * 双重锁就是害怕多线程中出现多个线程都进入了这里，此时都uniqueInstance为空，两者都要执行
         */
        if(uniqueInstance == null){
            synchronized (Singleton.class){
                /**
                 * 如果进到这里发现加锁之后对象还是为空，此时就说明没有别的线程，如果加锁之后发现不为空了，说明加锁期间有人已经实例化了
                 */
                if(uniqueInstance == null){
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

}

class Singleton3 {

    private Singleton3(){}

    private static class SingletonHolder{
        private static final Singleton3 INSTANCE = new Singleton3();
    }

    public static Singleton3 getUniqueInstance(){

        return SingletonHolder.INSTANCE;
    }

}

/**
 * 懒汉式，线程不安全，但是节省资源
 */
class Singleton1{
    private static volatile Singleton1 uniqueInstance;
    private Singleton1(){}

    public static Singleton1 getUniqueInstance(){
        /**
         * 多个线程同时进入到这里，如果uniqueInstance确实是null，这个时候就会多次实例化
         */
        if(uniqueInstance == null){
            uniqueInstance = new Singleton1();
        }
        return  uniqueInstance;
    }
}

/**
 * 饿汉式，安全，丢失了节约资源的好处
 */
class Singleton2{
    //饿汉式直接实例化，就不存在多次实例化的问题了
    private static volatile Singleton2 uniqueInstance = new Singleton2();
    private Singleton2(){}

    public static Singleton2 getUniqueInstance(){

        return  uniqueInstance;
    }
}