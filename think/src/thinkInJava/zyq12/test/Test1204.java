package thinkInJava.zyq12.test;

class MyException extends Exception{
    private String msg;
    MyException(String msg){
        this.msg = msg;
    }
    public void print(){
        System.out.println(msg);
    }
}

public class Test1204 {
    public static void f() throws MyException{
        throw new MyException("zyq");
    }
    public static void main(String[] args){
        try{
            f();
        }catch (MyException e){
            e.print();
            e.printStackTrace(System.out);
        }
    }
}
