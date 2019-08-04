package zyq07;

public class Test723 {
    public static void main(String[] args){
        Bee.f();
        System.out.println(Bee.s);
        Bee bee = new Bee();
    }
}

class Bee{
    static String s = "zyq";
    static void f(){
        System.out.println("zyqffff");
    }
}