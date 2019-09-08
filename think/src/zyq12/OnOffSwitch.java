package zyq12;

public class OnOffSwitch {
    private static  Switch sw = new Switch();
    public static void f() throws OnOffException1,OnOffException2 {}
    public static void main(String[] arg){
        try{
            sw.on();
            f();
//            sw.off();
        }catch (OnOffException1 e){
            System.out.println("OnOffException1");
//            sw.off();//可能有异常跳走，最后没有执行off，使用finally语句就可以不管任何情况都会执行off
        }catch (OnOffException2 e){
            System.out.println("OnOffException2");
//            sw.off();
        }finally {
            sw.off();
        }
    }
}
