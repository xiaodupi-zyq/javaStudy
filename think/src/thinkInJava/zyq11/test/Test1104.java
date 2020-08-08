package thinkInJava.zyq11.test;

import java.util.*;

class Generator{
    int key = 0;
    public String next(){
        switch (key){
            case 1:
                key ++;
                return "Snow White";
            case 2:
                key ++;
                return "Star Wars";
            case 3:
                key ++;
                return "Your name";
            default:
            case 4:
                key ++;
                return "natuo";
        }
    }

    public void fillA(String[] a){
        for (int i = 0; i < a.length; i++){
            a[i] = next();
        }
    }

    public Collection fill (Collection<String> c,int n){
        for (int i = 0; i < n;i++){
            c.add(next());
        }
        return c;
    }
}

public class Test1104 {
    public static void main(String[] args){
        Generator gen = new Generator();
        String[] a = new String[10];
        for(String s :a){
            System.out.println(s +",");
        }
        System.out.println();
        System.out.println(gen.fill(new ArrayList<>(),10));
        System.out.println(gen.fill(new LinkedList<>(),10));
        System.out.println(gen.fill(new HashSet<>(),10));
        System.out.println(gen.fill(new LinkedHashSet<>(),10));
        System.out.println(gen.fill(new TreeSet<>(),10));
    }
}
