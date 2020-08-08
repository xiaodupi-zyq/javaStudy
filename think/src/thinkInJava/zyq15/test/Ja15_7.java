package thinkInJava.zyq15.test;


import thinkInJava.zyq15.Generator;

import java.util.Iterator;

public class Ja15_7 implements Generator<Integer>,Iterable<Integer> {
    private int count = 0;
    public Integer next() { return fib(count++); }
    private int fib(int n) {
        if(n < 2) return 1;
        return fib(n-2) + fib(n-1);
    }
    private int size;
    public Ja15_7(){}
    public Ja15_7(int size){this.size=size;}
    public Iterator<Integer> iterator(){
        return new Iterator<Integer>(){
            public boolean hasNext(){return size>0;}
            public Integer next(){size--;return Ja15_7.this.next();}
            public void remove(){throw new RuntimeException();}

        };
    }
    public static void main(String[] args) {
        Ja15_7 gen = new Ja15_7();
        for(int i = 0; i < 18; i++)
            System.out.print(gen.next() + " ");
        System.out.println();
        for(Integer in:new Ja15_7(5))
            System.out.println(in);
    }
}

