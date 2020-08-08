package thinkInJava.zyq12;

class VeryImportantException extends Exception{
    public String toString(){
        return "A very important exception!";
    }
}

class HoHumException extends Exception{
    public String toString(){
        return "A trivial exception";
    }
}

class SimpleException1 extends Exception{
    public String toString(){
        return "A Very Simple Exception";
    }
}

public class LostMessage {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }
    void dispose() throws HoHumException {
        throw new HoHumException();
    }
    void simple() throws SimpleException1{
        throw new SimpleException1();
    }
    public static void main(String[] args){
        try {
            LostMessage lm = new LostMessage();
            try{
                lm.f();
            }finally {
                try {
                    lm.dispose(); //必须执行finally语句，将VeryImportantException异常给丢失了
                }finally {
                    lm.simple();
                }
            }
        }catch (Exception e) {
            System.out.println(e);
        }

    }
}
