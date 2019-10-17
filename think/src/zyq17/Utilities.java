package zyq17;

import java.util.*;

import static util.Print.print;

public class Utilities {
    static List<String> list = Arrays.asList("one Two three Four five six one" .split(" "));
    public static void main(String[] args){
        System.out.println(list);
        System.out.println("'list' disjoint (Four)?: " + Collections.disjoint(list,Collections.singletonList("Four")));
        System.out.println("max: " + Collections.max(list));
        System.out.println("min: " + Collections.min(list));
        System.out.println("ax w/ comparator: " + Collections.max(list,String.CASE_INSENSITIVE_ORDER));
        System.out.println("ax w/ comparator: " + Collections.min(list,String.CASE_INSENSITIVE_ORDER));
        List<String> sublist = Arrays.asList("Four five six".split(" "));
        print("indexOfSubList: " +
                Collections.indexOfSubList(list, sublist));
        print("lastIndexOfSubList: " +
                Collections.lastIndexOfSubList(list, sublist));
        Collections.replaceAll(list, "one", "Yo");
        print("replaceAll: " + list);
        Collections.reverse(list);
        print("reverse: " + list);
        Collections.rotate(list, 3);
        print("rotate: " + list);
        List<String> source =
                Arrays.asList("in the matrix".split(" "));
        Collections.copy(list, source);
        print("copy: " + list);
        Collections.swap(list, 0, list.size() - 1);
        print("swap: " + list);
        Collections.shuffle(list, new Random(47));
        print("shuffled: " + list);
        Collections.fill(list, "pop");
        print("fill: " + list);
        print("frequency of 'pop': " +
                Collections.frequency(list, "pop"));
        List<String> dups = Collections.nCopies(3, "snap");
        print("dups: " + dups);
        print("'list' disjoint 'dups'?: " +
                Collections.disjoint(list, dups));
        // Getting an old-style Enumeration:
        Enumeration<String> e = Collections.enumeration(dups);
        Vector<String> v = new Vector<String>();
        while(e.hasMoreElements())
            v.addElement(e.nextElement());
        // Converting an old-style Vector
        // to a List via an Enumeration:
        ArrayList<String> arrayList =
                Collections.list(v.elements());
        print("arrayList: " + arrayList);
    }
}

class ListSortSearch {
    public static void main(String[] args){
        List<String> list = new ArrayList<>(Utilities.list);
        list.addAll(Utilities.list);
        System.out.println(list);

        Collections.shuffle(list,new Random(47));
        System.out.println("Shuffled: " + list);

        ListIterator<String> it = list.listIterator(11);
        while(it.hasNext()){
            it.next();
            it.remove();
        }
        System.out.println("Trimmed: " + list);

        Collections.sort(list);
        System.out.println("Sorted: " + list);

        String key = list.get(7);
        int index = Collections.binarySearch(list,key);
        System.out.println("Location of " + key + " is " + index +", list.get(" + index + ") = " + list.get(index));

        Collections.sort(list,String.CASE_INSENSITIVE_ORDER);
        System.out.println("Case-insensitiv sorted: " + list);
        key = list.get(7);
        index = Collections.binarySearch(list,key,String.CASE_INSENSITIVE_ORDER);
        System.out.println("Location of " + key + " is " + index + ",list.get(" + index + ") = " + list.get(index));
    }
}