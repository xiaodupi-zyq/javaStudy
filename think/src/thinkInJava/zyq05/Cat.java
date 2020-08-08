package thinkInJava.zyq05;

public class Cat {
    static void f(String ... args) {
        System.out.println("len = "+args.length);
        for (String s:args) {
            System.out.println(s);
        }
    }
    public static void main(String... args) {
        f("sdfsf","rwr","rwge");
        String[] arg = {"sdsds","sdf","trg"};
        f(arg);
        for (String s:args) {
            System.out.println(s);
        }
    }
}
