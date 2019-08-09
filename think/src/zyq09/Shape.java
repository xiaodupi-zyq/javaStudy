package zyq09;

import java.util.Random;

interface Cycle{
    void ride();
    int wheels();
}

interface CycleFactory{
    Cycle getCycle();
}

class Unicycle implements Cycle{
    public void ride(){
        System.out.println("Unicycle " + wheels());
    }
    public int wheels(){
        return 1;
    }
}

class UnicycleFactory implements CycleFactory {
    public Cycle getCycle(){
        return new Unicycle();
    }
}

class Bicycle implements Cycle{
    public void ride(){
        System.out.println("Bicycle " + wheels());
    }
    public int wheels(){
        return 2;
    }
}

class BicycleFactory implements CycleFactory {
    public Cycle getCycle(){
        return new Bicycle();
    }
}

class Tricycle implements Cycle{
    public void ride(){
        System.out.println("Tricycle " + wheels());
    }
    public int wheels(){
        return 3;
    }
}

class TricycleFactory implements CycleFactory{
    public Cycle getCycle(){
        return new Tricycle();
    }
}

public class Shape {
    public static void drawCycle(CycleFactory cycleFactory){
        cycleFactory.getCycle().ride();
    }
    public static void main(String[] args){
        Random random = new Random(47);
        for(int i = 0 ; i < 10; i++){
            int temp = random.nextInt(3);
            switch (temp){
                case 0:
                    drawCycle(new UnicycleFactory());
                    break;
                case 1:
                    drawCycle(new BicycleFactory());
                    break;
                case 2:
                    drawCycle(new TricycleFactory());
                    break;
            }
        }
    }
}