package thinkInJava.zyq08;

public class Cycle{
    public void ride(){
        System.out.println("Cycle " + wheels());
    }
    public int wheels(){
        return 0;
    }
}

class Unicycle extends Cycle{
    public void ride(){
        System.out.println("Unicycle " + wheels());
    }
    public int wheels(){
        return 1;
    }
    public void balance(){
        System.out.println("Unicycle balance");
    }
}

class Bicycle extends Cycle{
    public void ride(){
        System.out.println("Bicycle " + wheels());
    }
    public int wheels(){
        return 2;
    }
    public void balance(){
        System.out.println("Bicycle balance");
    }
}

class Tricycle extends Cycle{
    public void ride(){
        System.out.println("Tricycle " + wheels());
    }
    public int wheels(){
        return 3;
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

        Cycle cycle1[] = {
                new Unicycle(),
                new Bicycle(),
                new Tricycle()
        };
        //
    }
}