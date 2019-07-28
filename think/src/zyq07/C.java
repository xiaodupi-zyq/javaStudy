package zyq07;

class A {
    A(int i){
        System.out.println("A constructor!!!");
    }
}

class B{
    B(int i){
        System.out.println("B constructor!!!");
    }
}

public class C extends A{
    C(){
        super(11);
    }
    private B b = new B(22);
    public static void main(String[] args){
        C c = new C();
    }
}
