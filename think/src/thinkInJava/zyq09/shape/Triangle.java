package thinkInJava.zyq09.shape;

import thinkInJava.zyq09.Supershape.Shape;

public class Triangle implements Shape {
    @Override
    public void draw(){
        System.out.println("Triangle.draw()");
    }
    @Override
    public void erase(){
        System.out.println("Triangle.erase()");
    }
    public void color(){
        System.out.println("Triangle's color");
    }
}
