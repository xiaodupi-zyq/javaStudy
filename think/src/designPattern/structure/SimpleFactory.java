package designPattern.structure;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 21:28 2020/8/6
 * @Modified By:
 */


/**
 * Product接口
 */
interface Product{}

/**
 * 三种具体实现类
 */
class ConcreteProduct1 implements Product {}
class ConcreteProduct2 implements Product {}
class ConcreteProduct3 implements Product{}

/**
 * 如果没有这个简单工厂类，要实现具体的每一个product的实现子类，我都需要进行直接去定义
 * 这样就不好维护类的实现，所以我们用简单工厂类来控制Product具体客户端，实现具体哪种类
 * 客户类不需要知道有哪些实现类，实现类也不直接对接客户类；
 * 客户类只需要给出具体实现的参数要求，也就是具体的需求，剩下由简单工厂类来实现；
 */
public class SimpleFactory {
    public Product createProduct(int type){
        if (type == 1) {
            return new ConcreteProduct1();
        } else if (type == 2) {
            return new ConcreteProduct2();
        }
        return new ConcreteProduct3();
    }
}

class client{
    //客户类只需要给出具体的参数剩下构造交给简单工厂类；
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Product product = simpleFactory.createProduct(1);
        // do something with the product
    }
}