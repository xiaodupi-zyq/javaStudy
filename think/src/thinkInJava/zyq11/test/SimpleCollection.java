package thinkInJava.zyq11.test;

import java.util.Collection;
import java.util.HashSet;

public class SimpleCollection {
    public static void main(String[] args){
        Collection<Integer> c = new HashSet<>();
        for (int i = 0; i < 10;i++){
            c.add(i);
        }
        c.add(2);//相同不存
        for (Integer i : c){
            System.out.println(i);
        }
    }
}
