package zyq14.test;

class A{

}
class B extends A{

}
class C extends B{

}

public class Test1408 {
    static void printInfo(Class a){
        System.out.println(a.getName());
        System.out.println(a.getDeclaredFields());
        try{
            printInfo(a.getSuperclass()); //递归循环
        }catch (Exception e){

        }
    }
    public static void main(String[] args){
        Class c = null;
        try{
            c = Class.forName("zyq14.test.C");
            printInfo(c);
        }catch (Exception e){
            e.printStackTrace(System.out);
        }
    }
}
