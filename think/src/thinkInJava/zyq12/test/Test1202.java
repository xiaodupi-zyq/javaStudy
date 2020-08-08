package thinkInJava.zyq12.test;

class A{
    void f(){

    }
}

public class Test1202 {
    public static void main(String[] args){
        try{
            A a = new A();
            a = null;
            a.f();
        }catch (Exception e){
            System.out.println("catch it");
            e.printStackTrace(System.out);
        }
    }
}
