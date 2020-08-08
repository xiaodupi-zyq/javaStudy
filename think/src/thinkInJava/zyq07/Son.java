package thinkInJava.zyq07;

class Father{
    Father(int i){
        System.out.println("Father constructor!!!");
    }
}

public class Son extends Father{
    Son(){
        super(11);
        System.out.println("Son default constructor!!!");
    }
    Son(int i){
        super(i);
        System.out.println("Son constructor!!!");
    }
    public static void main(String[] args){
        Son son = new Son();
        Son son1 = new Son(12);
    }
}
