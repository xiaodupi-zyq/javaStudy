package zyq08;

public class Cycle{
    public void ride(){
        System.out.println("Cycle");
    }
}

class Unicycle extends Cycle{
    public void ride(){
        System.out.println("Unicycle");
    }
}

class Bicycle extends Cycle{
    public void ride(){
        System.out.println("Bicycle");
    }
}

class Tricycle extends Cycle{
    public void ride(){
        System.out.println("Tricycle");
    }
}

class Draw{
    public void Drawing(Cycle i){
        i.ride();
    }
    public static void main(String[] args){
        //多态
        Cycle cycle = new Cycle();
        Unicycle unicycle = new Unicycle();
        Bicycle bicycle = new Bicycle();
        Tricycle tricycle = new Tricycle();
        cycle.ride();
        unicycle.ride();
        bicycle.ride();
        tricycle.ride();
    }
}