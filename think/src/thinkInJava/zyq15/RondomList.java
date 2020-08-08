package thinkInJava.zyq15;

import java.util.ArrayList;
import java.util.Random;

public class RondomList<T> {
    private ArrayList<T> storage = new ArrayList<>();
    private Random rand = new Random(47);
    public void add(T item) {storage.add(item);}
    public T select(){
        return storage.get(rand.nextInt(storage.size()));
    }
    public static void main(String[] args){
        RondomList<String> rs = new RondomList<>();
        for(String s : ("The quick brown fox jumped over the lazy brown dog").split(" ")){
            rs.add(s);
        }
        for(int i = 0; i < 11; i++){
            System.out.println(rs.select() + " ");
        }
    }
}
