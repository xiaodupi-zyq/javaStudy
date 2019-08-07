package zyq08;

class StaticSuper {
    public static String staticGet(){
        return "Base staticGet";
    }
    public static String dynamicGet() {
        return "Base dynamicGet";
    }
}

class StaticSub extends StaticSuper {
    public static String staticGet(){
        return "Derived staticGet";
    }
    public static String dynamicGet() {
        return "Derived dynamicGet";
    }
}

public class StaticPolymorphism {
    public static void main(String[] args){
        StaticSuper sup = new StaticSub();
        System.out.println(sup.staticGet());
        System.out.println(sup.dynamicGet());
    }
}
