package thinkInJava.zyq11.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Fish{
    private int len;
    Fish(int len){
        this.len = len;
    }

    public String toString(){
        return "len is " + len;
    }
}

public class Test1107 {
    public static void printlen(Iterator<Fish> fishIterator){
        while(fishIterator.hasNext()){
            Fish next = fishIterator.next();
            System.out.println(next.toString());
        }
    }
    public static void main(String[] args){
        ArrayList<Fish> fishs = new ArrayList<>();
        fishs.add(new Fish(2));
        fishs.add(new Fish(3));
        fishs.add(new Fish(4));
        fishs.add(new Fish(5));
        fishs.add(new Fish(6));
        fishs.add(new Fish(7));
        System.out.println(fishs.toString());
        List<Fish> sub = fishs.subList(1, 3);
        System.out.println(sub);
        System.out.println(fishs.containsAll(sub));
        fishs.removeAll(sub);
        System.out.println(fishs);
        System.out.println();
        printlen(fishs.iterator());
    }

}
