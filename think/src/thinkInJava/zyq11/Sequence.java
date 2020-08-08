package thinkInJava.zyq11;


import java.util.ArrayList;
import java.util.List;

class SeqContainer<T> {
    private List<T> container = new ArrayList<T>();
    public void add(T t) {
        container.add(t);
    }
}

interface Selector {
    boolean end();
    Object current();
    void next();
}

public class Sequence {
    private Object[] items;
    private int next = 0;
    public Sequence(int size){
        items = new Object[size];
    }
    public void add(Object x){
        if(next < items.length){
            items[next++] = x;
        }
    }
    //    使用了继承的方法实现了，另一种使用内部类
    private class SequenceSelector implements  Selector {
        private int i = 0;
        public boolean end() {
            return i == items.length;
        }
        public Object current() {return items[i];}
        public void next() {
            if(i < items.length)
                i++;
        }
        //对外部类的引用
        public Sequence outerClass (){
            return Sequence.this;
        }
//

    }
    public Selector selector(){
        return new SequenceSelector();
    }

    //  内部类实现上述差不多功能
    public Selector reverseSelector() {
        return new Selector() {
            private int i = 0;
            @Override
            public boolean end() {
                return i < 0;
            }

            @Override
            public Object current() {
                return items[i];
            }

            @Override
            public void next() {
                if(i >= 0)
                    i--;
            }
        };
    }

    public static void main(String[] args){

        Sequence sequence = new Sequence(10);
        for(int i = 0; i < 10; i++){
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while (!selector.end()){
            System.out.println(selector.current() + " ");
            selector.next();
        }
    }
}

