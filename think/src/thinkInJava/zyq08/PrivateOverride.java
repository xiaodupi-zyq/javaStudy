package thinkInJava.zyq08;

public class PrivateOverride {
    private void f() {
        System.out.println("private f()");
    }
    public static void main(String[] args){
        PrivateOverride p = new Derived();
        p.f();
    }
}

class Derived extends PrivateOverride {
    public void f() {
        System.out.println("Public f()");
    }
}
