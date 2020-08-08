package thinkInJava.zyq09;

interface A{
    void f();
}

interface B extends A{
    void g();
}
interface C extends A{
    void u();
}
interface D extends B,C{
    void v();
}

public class Test913 implements D{
    public void f(){}
    public void g(){}
    public void u(){}
    public void v(){}

}
