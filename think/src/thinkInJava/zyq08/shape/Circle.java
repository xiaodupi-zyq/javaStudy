package thinkInJava.zyq08.shape;

public class Circle extends Shape {
    @Override
    public void draw(){
        System.out.println("Circle.draw()");
    }
    @Override
    public void erase(){
        System.out.println("Circle.erase()");
    }
    public void color(){
        System.out.println("Circle's color");
    }
}
