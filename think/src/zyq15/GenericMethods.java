package zyq15;

public class GenericMethods {
    public <A,B,C> void f(A a,B b,C c,Integer integer) {//泛型参数表
        System.out.println(a.getClass().getName() + " " + b.getClass().getName() + " " + c.getClass().getName());
        System.out.println(integer.getClass().getName());
    }

    public static void main(String[] args){
        GenericMethods gm = new GenericMethods();
        gm.f("",'C',1.0,11);
    }
}
