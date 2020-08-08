package thinkInJava.zyq19;

import java.util.Random;

public class Enums {
    private static Random rand = new Random(47);
    public static <T extends Enum<T>> T random(Class<T> ec){
        return random(ec.getEnumConstants());
    }
    public static <T> T random(T[] values){
        return values[rand.nextInt(values.length)];
    }
}

enum Activity {
    SITTING,DODGING,JUMPING,FALLING,FLYING
}

class RandomTest{
    public static void main(String[] args){
        for(int i = 0; i < 20; i++){
            System.out.print(Enums.random(Activity.class) + " ");
        }
    }
}
