package thinkInJava.zyq10.test;

public class Test1007 {
    private int x = 10;
    private void f(){
        System.out.println("this functon is private!!!");
    }

    public class Inner{
        private int a = 1000;
        void g(){
            System.out.println("private x : " + x);
            f();
        }
    }
    void t(){
        Inner inner = new Inner();
        inner.g();
    }
    public static void main(String[] args){
        Test1007 test1007 = new Test1007();
        Test1007.Inner inner = test1007.new Inner();
        inner.g();

    }
}
