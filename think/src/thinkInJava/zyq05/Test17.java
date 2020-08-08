package thinkInJava.zyq05;

class Dog{
    Dog(String info){
        System.out.println(info);
    }
}


public class Test17 {

    public static void main(String[] args){
        Dog[] dogs = new Dog[20];
        for (int i=0;i < 20;i++){
            dogs[i] = new Dog(String.valueOf(i));
        }
        System.out.println("down");
    }

}
