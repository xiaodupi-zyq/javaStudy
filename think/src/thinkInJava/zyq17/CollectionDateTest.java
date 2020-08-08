package thinkInJava.zyq17;

import thinkInJava.zyq15.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

class Government implements Generator<String> {
    String [] foundation = ("strange women lying in ponds distributing swords is no basis for a system of government").split(" ");
    private int index;
    public String next() {
        return foundation[index++];
    }
}

public class CollectionDateTest {
    public static void main(String[] args){
        Set<String> set = new LinkedHashSet<>(new CollectionData<>(new Government(),15));
        set.addAll(CollectionData.list(new Government(),15));
        System.out.println(set);
    }
}
