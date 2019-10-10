package zyq17;

import zyq15.Generator;
import zyq16.CountingGenerator;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class MapData<K,V> extends LinkedHashMap<K,V> {
    public MapData(Generator<Pair<K,V>> gen, int quantity) {
        for(int i = 0; i < quantity; i++){
            Pair<K,V> p = gen.next();
            put(p.key,p.value);
        }
    }

    public MapData(Generator<K> genK ,Generator<V> genV,int quantity) {
        for(int i = 0; i < quantity; i++){
            put(genK.next(),genV.next());
        }
    }

    public MapData(Generator<K> genK, V value, int quantity) {
        for(int i = 0; i < quantity; i++) {
            put (genK.next(),value);
        }
    }

    public MapData(Iterable<K> genK,Generator<V> genV){
        for(K key : genK){
            put(key,genV.next());
        }
    }

    public MapData(Iterable<K> genK,V value){
        for(K key : genK){
            put(key,value);
        }
    }

    public static <K,V> MapData<K,V> map(Generator<Pair<K,V>> gen,int quantity){
        return new MapData<K,V>(gen,quantity);
    }

    public static <K,V> MapData<K,V> map(Generator<K> genK,Generator<V> genV,int quantity){
        return new MapData<K,V>(genK,genV,quantity);
    }

    public static <K,V> MapData<K,V> map(Generator<K> genK,V value,int quantity){
        return new MapData<K,V>(genK,value,quantity);
    }

    public static <K,V> MapData<K,V> map(Iterable<K> genK,Generator<V> genV){
        return new MapData<K,V>(genK,genV);
    }

    public static <K,V> MapData<K,V> map(Iterable<K> genK,V value){
        return new MapData<K,V>(genK,value);
    }
}

class Letters implements Generator<Pair<Integer,String>>,Iterable<Integer>{
    private int size = 9;
    private int number = 1;
    private char letter = 'A';
    public Pair<Integer,String> next(){
        return new Pair<>(number++ , "" + letter++);
    }
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return number < size;
            }

            @Override
            public Integer next() {
                return number++;
            }

            @Override
            public void remove() {
                throw  new UnsupportedOperationException();
            }
        };
    }
}

class MapDataTest {
    public static void main(String[] args){
        System.out.println(MapData.map(new Letters(),11));
        System.out.println(MapData.map(new CountingGenerator.Character(),new CountingGenerator.String(3) ,8));
        System.out.println(MapData.map(new CountingGenerator.Character(),"Value" ,6));
        System.out.println(MapData.map(new Letters(),new CountingGenerator.String(3)));
        System.out.println(MapData.map(new Letters(),"Pop"));
    }
}