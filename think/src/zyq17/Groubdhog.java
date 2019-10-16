package zyq17;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Groubdhog {
    protected int number;
    public Groubdhog(int n){
        number = n;
    }
    public String toString(){
        return "Groundhog #" + number;
    }
}

class Prediction {
    private static Random rand = new Random(47);
    private boolean shadow = rand.nextDouble() > 0.5;
    public String toString(){
        if(shadow){
            return "Six more weeks of Winter!";
        }
        else{
            return "Early Spring!";
        }
    }
}

class SpringDetector {
    public static <T extends Groubdhog> void detectSpring(Class<T> type) throws Exception {
        Constructor<T> ghog = type.getConstructor(int.class);
        Map<Groubdhog,Prediction> map = new HashMap<>();
        for(int i = 0; i < 10;i++){
            map.put(ghog.newInstance(i),new Prediction());
            System.out.println("map = " + map);
            Groubdhog gh = ghog.newInstance(3);
            System.out.println("Looking up prediction for " + gh);
            if(map.containsKey(gh)){
                System.out.println(map.get(gh));
            }else {
                System.out.println("Key not found: " + gh);
            }
        }
    }
    public static void main(String [] args) throws Exception {
        detectSpring(Groubdhog.class);
    }
}


class Groundhog2 extends Groubdhog {
    public Groundhog2(int n){
        super(n);
    }
    public int hashCode() {
        return number;
    }
    public boolean equals(Object o){
        return o instanceof Groundhog2 && (number == ((Groundhog2) o).number);
    }
}

class SpringDetector2 {
    public static void main(String[] args) throws Exception{
        SpringDetector.detectSpring(Groundhog2.class);
    }
}