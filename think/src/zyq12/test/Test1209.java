package zyq12.test;

import java.util.Random;

class MyException1 extends Exception{
    private String msg;
    MyException1(String msg){
        this.msg = msg;
    }
    public String toString(){
        return "MyException1" + msg;
    }
}
class MyException2 extends Exception{
    private String msg;
    MyException2(String msg){
        this.msg = msg;
    }
    public String toString(){
        return "MyException2" + msg;
    }
}
class MyException3 extends Exception{
    private String msg;
    MyException3(String msg){
        this.msg = msg;
    }
    public String toString(){
        return "MyException3" + msg;
    }
}

public class Test1209 {
    public static void f(int x) throws MyException1,MyException2,MyException3{
        switch (x){
            case 0:
                throw new MyException1("zyq1");
            case 1:
                throw new MyException2("zyq2");
            case 2:
                throw new MyException3("zyq3");
        }
    }
    public static void main(String[] args) throws Exception{
        Random random = new Random();
        try{
            f(random.nextInt() % 3);
        }catch (Exception e){
            if (e instanceof MyException1 | e instanceof MyException2 | e instanceof MyException3){
                System.out.println(e.toString());
                e.printStackTrace(System.out);
            }else {
                throw e;
            }
        }
    }
}
