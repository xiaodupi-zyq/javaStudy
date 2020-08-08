package thinkInJava.zyq12;

public class WhoCalled {
    static void f() {
        try {
            throw new Exception();
        }catch (Exception e) {
            for(StackTraceElement ste : e.getStackTrace()){
//                System.out.println(ste.getMethodName()); //获得发生异常的栈轨迹元素的方法名
                System.out.println(ste); // 获得发生异常的所有栈轨迹元素打印
            }
        }
    }
    static void g(){f();}
    static void h(){g();}
    public static void main(String[] args){
        f();
        System.out.println("------------------------------");
        g();
        System.out.println("------------------------------");
        h();
    }
}
