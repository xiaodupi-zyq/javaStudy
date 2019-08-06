package zyq08.shape;

public class Square extends Shape{
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
