package zyq14;

public class GenericClassReferences {
    public static void main(String[] args){
//        Class intClass = int.class;
//        Class<Integer> genericIntClass = int.class;
//        genericIntClass = Integer.class;
//        intClass = double.class;
//        genericIntClass = double.class;
        Class<?> intClass = int.class;
        intClass = double.class;
    }


}
