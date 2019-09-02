package zyq11.test;
// holding/Ex18.java
// TIJ4 Chapter Holding, Exercise 18, page 422
/* Fill a HashMap with key-value pairs. Print the results to show ordering
 * by hash code. Extract the pairs, sort by key, and place the result into a
 * LinkedHashMap. Show that the insertion order is maintained.
 */


import java.util.*;
/*
class Gerbil {
    private int gerbilNumber;
    public Gerbil(int i) {
        gerbilNumber = i;
    }
    public void hop() {
        System.out.println("gerbil " + gerbilNumber + " hops");
    }
    public String toString(){
        return "##: " + gerbilNumber + " hops";
    }
}


public class Ex18 {
    public static void main(String[] args) {
        Map<String, Gerbil> gerbils = new HashMap<String, Gerbil>();
        gerbils.put("A", new Gerbil(0));
        gerbils.put("B", new Gerbil(1));
        gerbils.put("C", new Gerbil(2));
        gerbils.put("D", new Gerbil(3));
        gerbils.put("E", new Gerbil(4));
        gerbils.put("F", new Gerbil(5));
        System.out.println(gerbils);    //{A=##: 0 hops, B=##: 1 hops, C=##: 2 hops, D=##: 3 hops, E=##: 4 hops, F=##: 5 hops}

        System.out.println();

        Set<String> sortedKeys = new TreeSet<>(gerbils.keySet()); //取键
        System.out.println(sortedKeys); //[A, B, C, D, E, F]

        System.out.println();

        Map<String, Gerbil> sortedGerbils = new LinkedHashMap<>();
        for(String s : sortedKeys) {
            System.out.print("Adding " + s + ", "); //Adding A, Adding B, Adding C, Adding D, Adding E, Adding F,
            sortedGerbils.put(s, gerbils.get(s));
        }
        System.out.println();
        System.out.println();
        System.out.println(sortedGerbils);
        System.out.println();
        // or, just:
        Map<String, Gerbil> sortedGerbils2 = new TreeMap<>(gerbils);
        System.out.println(sortedGerbils2);
    }
}
*/
import java.util.*;

class Gerbil {
    private int gerbilNumber;
    public Gerbil(int i) {
        gerbilNumber = i;
    }
    public void hop() {
        System.out.println("gerbil " + gerbilNumber + " hops");
    }
    public String toString(){
        return "##: " + gerbilNumber + " hops";
    }
}


public class Ex18 {
    public static void main(String[] args) {
        Map<String, Gerbil> gerbils = new HashMap<String, Gerbil>();
        gerbils.put("A", new Gerbil(0));
        gerbils.put("B", new Gerbil(1));
        gerbils.put("C", new Gerbil(2));
        gerbils.put("D", new Gerbil(3));
        gerbils.put("E", new Gerbil(4));
        gerbils.put("F", new Gerbil(5));
        System.out.println(gerbils);    //{A=##: 0 hops, B=##: 1 hops, C=##: 2 hops, D=##: 3 hops, E=##: 4 hops, F=##: 5 hops}

        System.out.println();

        Set<String> sortedKeys = new HashSet<>(gerbils.keySet()); //取键
        System.out.println(sortedKeys); //[A, B, C, D, E, F]

        System.out.println();

        Map<String, Gerbil> sortedGerbils = new LinkedHashMap<>();
        for(String s : sortedKeys) {
            System.out.print("Adding " + s + ", "); //Adding A, Adding B, Adding C, Adding D, Adding E, Adding F,
            sortedGerbils.put(s, gerbils.get(s));
        }
        System.out.println();
        System.out.println();
        System.out.println(sortedGerbils);
        System.out.println();
        // or, just:
        Map<String, Gerbil> sortedGerbils2 = new HashMap<>(gerbils);
        System.out.println(sortedGerbils2);
    }
}