package thinkInJava.zyq07;

class Art {
//    private Art() {     基类构造器总是会被调用
    Art() {
        System.out.println("Art constructor!!!");
    }
}

class Drawing extends Art {
    Drawing() {
        System.out.println("Drawing constructor!!!");
    }
}

public class Cartoon extends Drawing{
    public Cartoon() {
        System.out.println("Cartoon Constructor!!!");
    }
    public  static void main(String[] args){
        Cartoon x = new Cartoon();
    }
}
