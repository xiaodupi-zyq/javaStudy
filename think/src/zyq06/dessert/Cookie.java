package zyq06.dessert;

import zyq06.access.Widget;

public class Cookie {
    public Cookie(){
        System.out.println("Cookie constuctor");
    }
    void bite() {
        System.out.println("bite");
    }
    public static void main(String[] args){
        Widget widget = new Widget();
    }
}
