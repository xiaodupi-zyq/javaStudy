package thinkInJava.zyq09.shape;

import thinkInJava.zyq09.Supershape.Shape;

public class Star implements Shape {
    @Override
    public void draw(){
        System.out.println("Star.draw()");
    }
    @Override
    public void erase(){
        System.out.println("Star.erase()");
    }
    public void color(){
        System.out.println("Star's color");
    }
}
