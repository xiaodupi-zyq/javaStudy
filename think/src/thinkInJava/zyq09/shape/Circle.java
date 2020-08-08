package thinkInJava.zyq09.shape;

import thinkInJava.zyq09.Supershape.Shape;
//遵循shape类接口的导出类，implements
public class Circle implements Shape {
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
