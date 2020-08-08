package thinkInJava.zyq11.test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Test1112 {
    public static void main(String[] args){
        List<Integer> integers = new ArrayList<>();
        Random random = new Random(47);
        for (int i = 0; i < 8; i++){
            integers.add(random.nextInt() % 100);
        }
        System.out.println(integers);
        List<Integer> integers1 = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            integers1.add(random.nextInt() % 74);
        }
        System.out.println(integers1);
        ListIterator<Integer> iterator = integers.listIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next() + "," + iterator.previousIndex() + "," + iterator.nextIndex() + ";");
        }
        while(iterator.hasPrevious()){
            integers1.add(iterator.previous());
        }
        System.out.println(integers1);
    }
}
