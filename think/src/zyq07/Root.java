package zyq07;

class Component1{
    Component1(){
        System.out.println("Component1 constructor!!!");
    }
}

class Component2{
    Component2(){
        System.out.println("Component2 constructor!!!");
    }
}

class Component3{
    Component3(){
        System.out.println("Component3 constructor!!!");
    }
}

public class Root {

    private Component1 component1 = new Component1();
    private Component2 component2 = new Component2();
    private Component3 component3 = new Component3();
    Root(int i){
        System.out.println("Root constructor!!!");
    }
}

class Stem extends Root {
    Stem() {
        super(111);
        System.out.println("Stem Constructor!!!");
    }
    public static void main(String[] args){
        Stem stem = new Stem();
    }
}
