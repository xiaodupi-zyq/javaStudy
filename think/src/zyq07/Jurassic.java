package zyq07;

class SmallBrain{}

final class Dinosaur {
    int i  = 7;
    int j = 1;
    SmallBrain x = new SmallBrain();
    void f(){}
}

//public class Jurassic extends Dinosaur{
//}       //Dinosaur是final类，是无法被继承的
public class Jurassic{
    public static void main(String[] args){
        Dinosaur n = new Dinosaur();
        n.f();
        n.i = 40;
        n.j++;
    }
}