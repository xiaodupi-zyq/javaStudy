package zyq08;

public class Test816 {
    public static void main(String[] args){
        stage s = new stage();
        s.move();
        Which w = Which.SMALL;
        Which w1 = Which.MIDD;
        Which w2 = Which.BIG;
        s.change(w1);
        s.move();
        s.change(w2);
        s.move();
    }
}
class StarShip{
    public void action(){}
}
class SmallShip extends StarShip{
    @Override
    public void action() {
        System.out.println("run");
    }
}
class MiddShip extends StarShip{
    @Override
    public void action() {
        System.out.println("fly");
    }
}
class BigShip extends StarShip{
    @Override
    public void action() {
        System.out.println("jump");
    }
}
class stage{
    private StarShip ship = new SmallShip();
    public void change(Which w){
        switch (w){
            case SMALL:
                ship = new SmallShip();
                break;
            case MIDD:
                ship = new MiddShip();
                break;
            case BIG:
                ship = new BigShip();
                break;
        }
    }
    public void move(){
        ship.action();
    }
}
enum Which{
    SMALL,MIDD,BIG;
}