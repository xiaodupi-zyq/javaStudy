package thinkInJava.zyq08;

public class Test810 {
    public void name(){
        System.out.println("name");
        sex();
    }
    public void sex(){
        System.out.println("sex");
    }
}

class Bob extends Test810{
    public void sex(){
        System.out.println("boy");
    }
}
class Student{
    public static void main(String[] args){
        Bob bob = new Bob();
        bob.name();
    }
}
