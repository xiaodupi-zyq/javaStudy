package thinkInJava.zyq10.test;

public class Test1002 {
    private Object[] items;
    private int next = 0;
    public Test1002(int size) {
        items = new Object[size];
    }
    public void add(Object o) {
        if (next < items.length) {
            items[next++] = o;
        }
    }
    //迭代器设计模式，对外公布一个选择器，可以按照你所设计的顺序访问内部的存储的数据
    //外部使用者不需要关心该类的具体实现，体现了封装的原则
    private class SequenceSelector implements Selector {   //内部类，能访问外部类的所有成员，遵循Selector这样的接口
        private int i = 0;
        @Override
        public boolean end() {
            return i == items.length;
        }
        @Override
        public Object current() {
            return items[i];
        }
        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }
    public Selector selector() {
        return new SequenceSelector();  //该方法返回一个内部类的引用
    }
    public static void main(String[] args){
        Test1002 t = new Test1002(10);
        for (int i = 0; i < 10; i++) {
            t.add(new myClass(i+""));     //相比前面的例子，只是将数据的类型进行了更换
        }
        Selector selector = t.selector();
        while (!selector.end()){
            System.out.println(selector.current());
            selector.next();
        }
    }
}
class myClass{
    String str;
    public myClass(String s){
        str = s;
    }
    @Override
    public String toString() {
        return str + " " + str;
    }
}
interface Selector{
    boolean end();
    Object current();
    void next();
}

