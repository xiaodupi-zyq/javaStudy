package zyq17;

import java.util.*;

public class ReadOnly {
    static Collection<String> data = new ArrayList<>(Countries.names(6));
    public static void main(String[] args){
        Collection<String> c = Collections.unmodifiableCollection(new ArrayList<>(data));
        //c.add("one");
        System.out.println(c);
        //unmodifiableList无法修改的
        List<String> a = Collections.unmodifiableList(new ArrayList<>(data));
        ListIterator<String> lit = a.listIterator();
        System.out.println(lit.next());
//        lit.add("one");
    }
}
