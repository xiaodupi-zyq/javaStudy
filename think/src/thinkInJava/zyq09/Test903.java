package thinkInJava.zyq09;

abstract class Out{
    public abstract void print();
    Out(){
        print();
    }
}

class Iout extends Out{
    private int i = 17;
    public void print(){
        System.out.println(i);
    }
}

public class Test903 {
    public static void main(String[] args){
        Iout iout = new Iout();
        iout.print();
    }
}
