package thinkInJava.zyq09;

interface Dog{
    void f();
    void g();
}
interface Cat{
    void u();
    void v();
}
interface Pig{
    void s();
    void t();
}

interface Ani extends Dog,Cat,Pig{
    void w();
}

class Peo{
    public void x(){};
}

public class Test914 extends Peo implements Ani{
    public void f(){}
    public void g(){}
    public void u(){}
    public void v(){}
    public void s(){}
    public void t(){}
    public void w(){}
    public void qqq(Dog dog){}
    public void aaa(Cat cat){}
    public void zzz(Pig pig){}
    public void xxx(Ani ani){}
    public static void main(String[] args){
        Test914 test914 = new Test914();
        test914.aaa(test914);
        test914.qqq(test914);
        test914.zzz(test914);
        test914.xxx(test914);
    }
}
