package thinkInJava.zyq13;

import java.util.Formatter;

public class Conversion {
    public static  void main(String[] args){
        Formatter f = new Formatter(System.out);
        char u = 'a';
        System.out.println("u = 'a'");
        f.format("s:%s\n",u);
    }
}
