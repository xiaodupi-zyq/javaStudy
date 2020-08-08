package thinkInJava.zyq09.shape;


import thinkInJava.zyq08.shape.Shape;

public class Shapes {
    private static RandomShapeGenerator gen = new RandomShapeGenerator();
    public static void main(String[] args){
//        Shape shape = new Shape();
//        shape.color();      //并不在一个包中，且没有继承关系，可以直接访问方法，接口中默认方法public
        Shape[] s = new Shape[9];
        for (int i = 0; i < s.length; i++){
            s[i] = gen.next();
        }
        for(Shape shp : s){
            shp.draw();
            shp.color();
        }
    }
}
