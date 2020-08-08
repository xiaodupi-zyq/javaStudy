package thinkInJava.zyq09.shape;

import thinkInJava.zyq08.shape.Circle;
import thinkInJava.zyq08.shape.Square;
import thinkInJava.zyq08.shape.Star;
import thinkInJava.zyq08.shape.Triangle;
import thinkInJava.zyq08.shape.*;

import java.util.Random;

public class RandomShapeGenerator {
    private Random rand = new Random(55);
    public Shape next(){
        switch(rand.nextInt(4)){
            default:
            case 0:return new Circle();
            case 1:return new Square();
            case 2:return new Triangle();
            case 3:return new Star();
        }
    }
}
