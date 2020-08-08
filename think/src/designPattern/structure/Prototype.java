package designPattern.structure;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 10:19 2020/8/7
 * @Modified By:
 */
public abstract class Prototype {
    abstract Prototype myClone();
}

class CretePrototype extends Prototype {
    private String filed;
    public CretePrototype(String filed) {
        this.filed = filed;
    }

    @Override
    Prototype myClone() {
        return new CretePrototype(filed);
    }
    @Override
    public String toString(){
        return filed;
    }
}

class Client {
    public static void main(String[] args){
        Prototype prototype = new CretePrototype("abc");
        Prototype clone = prototype.myClone();
        System.out.println(clone.toString());
    }
}


