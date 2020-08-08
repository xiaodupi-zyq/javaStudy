package thinkInJava.zyq16;

import thinkInJava.zyq15.Generator;

import java.util.ArrayList;
import java.util.Arrays;

public class Generated {
    public static <T> T[] array(T[] a, Generator<T> gen){
        return new CollectionData<T>(gen,a.length).toArray(a);
    }
    @SuppressWarnings("unchecked")
    public static <T> T[] array(Class<T> type, Generator<T> gen, int size){
        T[] a = (T[]) java.lang.reflect.Array.newInstance(type,size);
        return new CollectionData<T>(gen,size).toArray(a);
    }
}
class CollectionData<T> extends ArrayList<T>{
    public CollectionData(Generator<T> gen, int quantity){
        for(int i = 0; i < quantity; i++){
            add(gen.next());
        }
    }
//    public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
//        return new CollectionData<>(gen, quantity);
//    }
}

class TestGenerated {
    public static void main(String[] args){
        Integer[] a = {9,8,7,6};
        System.out.println(Arrays.toString(a));
        a = Generated.array(a,new CountingGenerator.Integer());
        System.out.println(Arrays.toString(a));
        Integer[] b = Generated.array(Integer.class,new CountingGenerator.Integer(),15);
        System.out.println(Arrays.toString(b));
    }
}