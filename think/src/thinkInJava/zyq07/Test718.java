package thinkInJava.zyq07;

class Myself{
    private int i;
    Myself (int i ){
        this.i = i;
    }
    public String toString (){
        return "i = " + i;
    }
}

public class Test718 {
    private static Myself myself = new Myself(1);
    private final Myself myself1 = new Myself(2);
    private static final Myself myself2 = new Myself(3);
    public static  void main(String[] args){
        Test718 t = new Test718();
        System.out.println(t.myself);
        System.out.println(t.myself1);
        System.out.println(t.myself2);
        Test718 t1 = new Test718();
        System.out.println(Test718.myself);
        System.out.println(t1.myself1);
        System.out.println(Test718.myself2);
    }
}
