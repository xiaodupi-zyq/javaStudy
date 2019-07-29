package zyq07;
class Phone{
    String smartPhone(int i){
        System.out.println("samrt Phone " + i);
        return "Huawei";
    }
    String samrtPhone(float f){
        System.out.println("samrt Phone " + f + " f");
        return "Vivo";
    }
    String smartPhone(String s){
        System.out.println("smart Phone " + s +" s");
        return "OPPO";
    }

}
public class Apple extends Phone{
    String smartPhone(char c){
        System.out.println("smart Phone "+ c + " c");
        return "Apple";
    }
    public static void main(String[] args){
        Apple apple = new Apple();
        apple.smartPhone('a');
        apple.smartPhone(1);
        apple.samrtPhone(1.0f);
        apple.smartPhone("sss");
    }
}
