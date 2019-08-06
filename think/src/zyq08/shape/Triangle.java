package zyq08.shape;

public class Triangle extends Shape{
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
