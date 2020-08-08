package thinkInJava.zyq14;

import java.util.Arrays;
import java.util.List;

abstract class Shape {
    void draw(){
        System.out.println(this + ".draw()");
    }
    abstract public String toString();
    void rotate(){
        if(this instanceof Circle){
            System.out.println("circle");
        }else{
            System.out.println("not circle");
        }
    }
}

class Circle extends Shape {
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {
    int flag = 1;
    public String toString() {
        return "Square" + flag;
    }
}

class Triangle extends Shape {
    public String toString() {
        return "Triangle";
    }
}

class Rhomboid extends Shape {
    public String toString() {
        return "Rhomboid";
    }
}

public class Shapes {
    public static void main(String[] args){
        List<Shape> shapeList = Arrays.asList(new Circle(),new Square(),new Triangle(),new Rhomboid());
        for(Shape shape : shapeList){
            shape.draw();
            shape.rotate();
        }

        try {
            Shape a = new Rhomboid();
            if(a instanceof Shape) {
                a.draw();
            }
            if(a instanceof Rhomboid) {//instanceof 判断类型的关键字
                ((Rhomboid) a).draw();
            }
            else if(a instanceof Circle) {
                ((Circle) a).draw();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}