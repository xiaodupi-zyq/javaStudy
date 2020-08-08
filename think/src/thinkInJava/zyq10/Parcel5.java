package thinkInJava.zyq10;

public class Parcel5 {
    public Destination destination(String s){
//        在方法的定义域中定义内部类，内部类继承了外部的一个Destation的接口，之后返回时进行向上转型
        class PDestation implements Destination {
            private String label;
            private PDestation(String whereTo){
                label = whereTo;
            }
            public String readLabel(){
                return label;
            }
        }
        return new PDestation(s);
    }
    public static void main(String[] args){
        Parcel5 p = new Parcel5();
        Destination d = p.destination("Tasmania");
    }
}
