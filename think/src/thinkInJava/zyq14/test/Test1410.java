package thinkInJava.zyq14.test;

public class Test1410 {
    static void Aa(Class obj){
        System.out.println(obj.getName());
        try{
            Aa(obj.getSuperclass());
        }catch (Exception e){

        }
    }
    public static void main(String[] args){
        char[] a = new char[5];
        try{
            Class c = a.getClass();
            Aa(c);
        }catch (Exception e){
            e.printStackTrace(System.out);
        }
    }
}
