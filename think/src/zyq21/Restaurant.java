package zyq21;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Meal{
    private final int orderNum;
    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }
    public String toString() {
        return "Meal " + orderNum;
    }
}

class WaitPerson implements Runnable{
    private Restaurant restaurant;
    protected boolean clean = true;
    public WaitPerson (Restaurant r) {
        restaurant = r;
    }
    public void run() {
        try{
            while(!Thread.interrupted()){
                //餐厅食物为空，则wait

                synchronized (this) {
                    while (restaurant.meal == null){
                        wait();
                    }
                }
                System.out.println("Waitperson got " + restaurant.meal);
                //否则，餐厅食物状态置0，唤醒厨师
                synchronized (restaurant.chef){
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();
                }
                System.out.println("WaitPerson delivered " + restaurant.meal);
                synchronized(restaurant.busBoy) {
                    clean = false;
                    restaurant.busBoy.notifyAll(); // for cleanup
                }
            }
        }catch (InterruptedException e){
            System.out.println("WaitPerson interrupted");
        }
    }
}

class BusBoy implements Runnable{
    private Restaurant restaurant;
    public BusBoy (Restaurant r) {
        restaurant = r;
    }
    public void run(){
        try{
            while (!Thread.interrupted()){
                synchronized(this) {
                    while(restaurant.waitPerson.clean)
                        wait();
                }
                System.out.println("BusBoy cleaning up " + restaurant.meal);
                restaurant.waitPerson.clean = true;

            }
        }catch (InterruptedException e) {
            System.out.println("BusBoy interrupted");
        }
    }
}

class Chef implements Runnable{
    private Restaurant restaurant;
    private int count = 0;
    private Random random = new Random(47);
    public Chef(Restaurant r) {
        restaurant = r;
    }
    public void run(){
        try{
            while(!Thread.interrupted()) {
                //自己本身的锁，如果餐厅的食物不是null，那么自己进入wait状态，锁释放
                synchronized (this) {
                    while (restaurant.meal != null){
                        wait();
                    }
                }
                //如果食物超过十次则打烊，终端线程
//                count = random.nextInt(54);
                if(++count == 10) {
                    System.out.println("Out of food, closing");
                    restaurant.exec.shutdownNow();
                }
                System.out.print("Order up!  ");
                //服务员的锁，产生食物，唤醒服务员
                synchronized (restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
//                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch (InterruptedException e){
            System.out.println("Chef interrupted");
        }
    }
}

public class Restaurant {
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);
    BusBoy busBoy = new BusBoy(this);
    public Restaurant(){
        exec.execute(chef);
        exec.execute(waitPerson);
        exec.execute(busBoy);
    }
    public static void main(String[] args){
        new Restaurant();
    }
}
