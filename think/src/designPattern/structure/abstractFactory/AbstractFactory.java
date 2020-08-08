package designPattern.structure.abstractFactory;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 22:33 2020/8/6
 * @Modified By:
 */



class AbstractProductA {}

class AbstractProductB {}

class ProductA1 extends AbstractProductA {

}

class ProductA2 extends AbstractProductA{

}

class ProductB1 extends AbstractProductB{

}

class ProductB2 extends AbstractProductB{

}

public abstract class AbstractFactory {
    abstract AbstractProductA createProductA();

    abstract AbstractProductB createProductB();
}

class ConcreteFactory1 extends AbstractFactory {
    AbstractProductA createProductA() {
        return new ProductA1();
    }

    AbstractProductB createProductB() {
        return new ProductB1();
    }
}

class ConcreteFactory2 extends AbstractFactory {
    AbstractProductA createProductA() {
        return new ProductA2();
    }

    AbstractProductB createProductB() {
        return new ProductB2();
    }
}

class Client {
    public static void main(String[] args){
        AbstractFactory abstractFactory = new ConcreteFactory1();
        AbstractProductA productA = abstractFactory.createProductA();
        AbstractProductB productB = abstractFactory.createProductB();
    }
}