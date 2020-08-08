package thinkInJava.zyq10;

public class DotThis {
    void f() {
        System.out.println("DotThis.f()");
    }
    public class Inner {
        public DotThis outer() {
            return DotThis.this; //调用外层的外部类
        }
    }
    public Inner inner() {
        return new Inner();
    }
    public static void main (String[] args){
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        dti.outer().f();
    }
}
