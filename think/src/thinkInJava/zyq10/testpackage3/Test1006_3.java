package thinkInJava.zyq10.testpackage3;

import thinkInJava.zyq10.testpackage1.Test1006_1;
import thinkInJava.zyq10.testpackage2.Test1006_2;

public class Test1006_3 extends Test1006_2 {
    public Test1006_1 g(){
        Test1006_2 outer = new Test1006_2();
        Test1006_2.Inner inner = outer.new Inner();
        return inner;
    }
}
class Test1006{
    public static void main(String[] args){
        Test1006_3 temp = new Test1006_3();
        Test1006_1 x = temp.g();
        x.f();
    }

}