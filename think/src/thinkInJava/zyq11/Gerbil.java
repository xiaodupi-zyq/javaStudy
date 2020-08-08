package thinkInJava.zyq11;

import java.util.*;

//public class Gerbil {
//    private int gerbilNumber;
//    Gerbil(int gerbilNumber){
//        this.gerbilNumber = gerbilNumber;
//    }
//    public void hop(){
//        System.out.println("number:" + gerbilNumber + " is jumping");
//    }
//    public static void main(String[] args){
//        ArrayList<Gerbil> gerbils = new ArrayList<>();
//        gerbils.add(new Gerbil(12));
//        gerbils.add(new Gerbil(17));
//        gerbils.add(new Gerbil(19));
//        gerbils.add(new Gerbil(20));
//        gerbils.add(new Gerbil(24));
//        gerbils.add(new Gerbil(30));
//        for(Gerbil g : gerbils){
//            g.hop();
//        }
//        Iterator<Gerbil> gerbilIterator = gerbils.iterator();
//        while (gerbilIterator.hasNext()){
//            Gerbil next = gerbilIterator.next();
//            next.hop();
//        }
//    }
//}

public class Gerbil {
    private int gerbilNumber;
    Gerbil(int gerbilNumber){
        this.gerbilNumber = gerbilNumber;
    }
    public void hop(){
        System.out.println("number:" + gerbilNumber + " is jumping");
    }
    public static void main(String[] args){
        ArrayList<Gerbil> gerbils = new ArrayList<>();
        gerbils.add(new Gerbil(12));
        gerbils.add(new Gerbil(17));
        gerbils.add(new Gerbil(19));
        gerbils.add(new Gerbil(20));
        gerbils.add(new Gerbil(24));
        gerbils.add(new Gerbil(30));

        Map<Integer,Gerbil> gerbilMap = new HashMap<>();
        gerbilMap.put(12,new Gerbil(12));
        gerbilMap.put(17,new Gerbil(17));
        gerbilMap.put(19,new Gerbil(19));
        gerbilMap.put(20,new Gerbil(20));
        gerbilMap.put(24,new Gerbil(24));
        gerbilMap.put(30,new Gerbil(30));
        Iterator<Integer> iterator = gerbilMap.keySet().iterator();
        while(iterator.hasNext()){
            int indexof = iterator.next();
            System.out.println(indexof);
            Gerbil next = gerbilMap.get(indexof);
            System.out.println(next.hashCode());
            next.hop();
        }


//        Iterator<Gerbil> gerbilIterator = gerbils.iterator();
//        while (gerbilIterator.hasNext()){
//            Gerbil next = gerbilIterator.next();
//            next.hop();
//        }
    }
}
