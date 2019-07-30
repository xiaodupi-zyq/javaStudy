package zyq07;

public class TestList {
    public static void main(String[] args){
        double x = 1.534;
        double y = 1.53535;
        String xs = String.valueOf(x);
        String ys = String.valueOf(y);
        System.out.println(xs);
        System.out.println(ys);
        if (xs.compareTo(ys) > 0){
            System.out.println("111");
        }
        else {
            System.out.println("222");
        }
    }

}

