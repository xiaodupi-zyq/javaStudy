package designPattern.structure;

/**
 * @Author: zyq-xiaoliuzi
 * @Description: 工厂模式
 * @Date: Created in 21:57 2020/8/6
 * @Modified By:
 */

/**
 * 抽象类实现工厂，其中包含一个抽象方法，需要子类来实现
 */
public abstract class Factory {
    abstract public Product factoryMethod();

    /**
     * doSomething需要一个Product的对象，就找factoryMethod()要
     */
    public void doSomething(){
        Product product = factoryMethod();
    }
}

class ConcreteFactory1 extends Factory{
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct1();
    }
}

class ConcreteFactory2 extends Factory{
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct2();
    }
}

class ConcreteFactory3 extends Factory{
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct3();
    }
}