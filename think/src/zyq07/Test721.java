package zyq07;

class ClassWithFinals{
    final void f(){
        System.out.println("Class with Finals!!!");
    }
}

public class Test721 extends ClassWithFinals{
//    void f(){
//        System.out.println("class with finals!!!");
//    }
//    无法覆写f方法，因为在基类中f方法是final，是禁止导出类覆写的
    public static void main(String[] args){

    }

}
