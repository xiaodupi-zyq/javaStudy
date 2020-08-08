package thinkInJava.zyq15;

public class Holder3<T> {
    private T a;
    public Holder3(T a){this.a = a;}
    public void set(T a) { this.a = a;}
    public T get(){
        return a;
    }
    public static void main(String[] args){
        Holder3<Automobile> h3 = new Holder3<>(new Automobile());//创建holder3的时候要指明持有什么类型的对象，然后你就只能在holder3中持有这种类型的对象
        Automobile a = h3.get();
    }

}
