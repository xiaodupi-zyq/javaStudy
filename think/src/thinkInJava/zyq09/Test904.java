package thinkInJava.zyq09;

abstract class Animal{
    abstract void name();
}

class Rabbit extends Animal{
    @Override
    public void name(){
        System.out.println("Rabbit");
    }
    static void eat(Animal animal){
        animal.name();
    }
}

public class Test904 {
    public static void main(String[] args){
        Animal rabbit = new Rabbit();
        Rabbit.eat(rabbit);
    }
}
