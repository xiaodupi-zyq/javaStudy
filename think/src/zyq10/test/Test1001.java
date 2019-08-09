package zyq10.test;

class Outer {
    class Inner {

    }
    public Inner f(){
        return new Inner();
    }
    public static void main(String [] args){
        Outer outer = new Outer();
        Outer.Inner inner = outer.f();
    }
}