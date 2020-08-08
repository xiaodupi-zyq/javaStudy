package thinkInJava.zyq08.shape;

public class Star extends Shape{
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
