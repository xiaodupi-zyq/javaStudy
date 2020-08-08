package thinkInJava.zyq15;

import java.util.*;

class Zyq{

}
class Hdd{

}

class Zxh{

}

public class New {
    public static <K,V> Map<K,V> map(){
        return new HashMap<>();
    }
    public static <T> List<T> list(){
        return new ArrayList<>();
    }
    public static <T> LinkedList<T> llist(){
        return new LinkedList<>();
    }
    public static <T> Set<T> set(){
        return new HashSet<>();
    }
    public static <T> Queue<T> queue(){
        return new LinkedList<>();
    }

    public static void main(String[] args){
        Map<String,List<String>> sls = New.map();
        List<String> ls = New.list();
        LinkedList<String> lls = New.llist();
        Set<String> ss = New.set();
        Queue<String> qs = New.queue();
        Map<Zyq,LinkedList<Hdd>> sla = New.map();
    }
}

