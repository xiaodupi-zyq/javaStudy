package thinkInJava.zyq12.test;

public class Test1201 {
    public static void f() throws Exception{
        System.out.println("throw a exception");
        throw new Exception("qwera");
    }
    public static void main(String[] args){
        try{
            f();
        } catch (Exception e){
            System.out.println("catch it");
            e.printStackTrace(System.out);
            System.out.println("catch it");
        }
    }
}
