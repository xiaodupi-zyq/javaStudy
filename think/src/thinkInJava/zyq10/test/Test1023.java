package thinkInJava.zyq10.test;

interface U{
    void f();
    void g();
    void h();
}

class A{
    U makeU(){
        return new U() {
            @Override
            public void f() {
                System.out.println("A,U,f");
            }

            @Override
            public void g() {
                System.out.println("A,U,g");
            }

            @Override
            public void h() {
                System.out.println("A,U,h");
            }
        };
    }
}

class B{
    private U[] u = new U[5];
    public void addU(U[] u,U x){
        if(u.length < 5){
            u[u.length] = x;
        }
    }
    public void setNull(int i){
        if (i < u.length){
            u[i] = null;
        }
    }
    public void selector(){
        for(U item : u){
            System.out.println(item);
        }
    }
}

public class Test1023 {
}
