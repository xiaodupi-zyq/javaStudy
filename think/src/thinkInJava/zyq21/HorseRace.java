package thinkInJava.zyq21;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static thinkInJava.util.Print.print;

class Horse implements Runnable {
    private static int counter = 0;//马的数量
    private final int id = counter++;//马的id
    private int strides = 0; //步数
    private static Random rand = new Random(47);
    private static CyclicBarrier barrier;
    public Horse(CyclicBarrier b) {
        barrier = b;
    } //构造函数，持有CyclicBarrier对象
    public synchronized int getStrides() {return strides;}
    public void run() {
        try {
            while(!Thread.interrupted()){
                synchronized (this) {
                    strides += rand.nextInt(5);
                }
                barrier.await();
            }
        }catch (InterruptedException e) {

        }catch (BrokenBarrierException e){
            throw new RuntimeException(e);
        }
    }
    public String toString() {return "Horse " + id + " ";}
    public String tracks() {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < getStrides(); i++){
            s.append("*");
        }
        s.append(id);
        return s.toString();
    }
}

public class HorseRace {
    static final int FINISH_LINE = 75; //总长度75
    private List<Horse> horses = new ArrayList<>(); //存储马的List
    private ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier barrier; //同一个CyclicBarrier对象
    public HorseRace(int nHorses,final int pause) { //构造函数，nHorse代表n匹马，也就是n个线程
        barrier = new CyclicBarrier(nHorses, new Runnable() {
            @Override
            public void run() {
                StringBuilder s = new StringBuilder();
                for(int i = 0;i <FINISH_LINE; i++) {
                    s.append("=");
                } //画出赛道
                print(s);
                //画出每一匹马的位置
                for(Horse horse : horses)
                    print(horse.tracks());
                //如果有一匹马超过终点线，则胜出，比赛结束（中断线程）
                for(Horse horse : horses)
                    if(horse.getStrides() >= FINISH_LINE) {
                        print(horse + "won!");
                        exec.shutdownNow();
                        return;
                    }
                try {
                    TimeUnit.MILLISECONDS.sleep(pause);
                } catch(InterruptedException e) {
                    print("barrier-action sleep interrupted");
                }
            }
        });
        for(int i = 0; i < nHorses; i++) {
            Horse horse = new Horse(barrier);
            horses.add(horse); //创建赛马
            exec.execute(horse);//添加线程
        }
    }
    public static void main(String[] args) {
        int nHorses = 7;
        int pause = 200;
        if(args.length > 0) { // Optional argument
            int n = new Integer(args[0]);
            nHorses = n > 0 ? n : nHorses;
        }
        if(args.length > 1) { // Optional argument
            int p = new Integer(args[1]);
            pause = p > -1 ? p : pause;
        }
        new HorseRace(nHorses, pause);
    }
}