package zyq15.test;

public class Test1502<T> {
    private T a;
    private T b;
    private T c;

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public T getB() {
        return b;
    }

    public void setB(T b) {
        this.b = b;
    }

    public T getC() {
        return c;
    }

    public void setC(T c) {
        this.c = c;
    }

    public Test1502(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static void main(String[] args){
        Test1502<Integer> test1502 = new Test1502<>(1,2,3);
        System.out.println(test1502.getA() + " " + test1502.getB() + " " + test1502.getC());
    }
}
