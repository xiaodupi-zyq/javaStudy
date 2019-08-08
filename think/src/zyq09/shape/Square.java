package zyq09.shape;

import zyq09.Supershape.Shape;

public class Square implements Shape {
    @Override
    public void draw(){
        System.out.println("Square.draw()");
    }
    @Override
    public void erase(){
        System.out.println("Square.erase()");
    }
    public void color(){
        System.out.println("Square's color");
    }
}
