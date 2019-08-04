package zyq07;

class OverridingPrivate20 extends WithFinals{
//    @Override   //使用override表示是想重写基类方法，但基类中的final，或者隐含final的private关键词相互冲突
    private final void f(){
        System.out.println("OverridingPrivate20.f()");
    }
//    @Override
    protected void g(){
        System.out.println("OverridingPrivate20.g()");
    }

}

class OverridingPrivate30 extends OverridingPrivate20{
//    @Override
    public final void f(){
        System.out.println("OverridingPrivate30.f()");
    }
    @Override
    public void g(){
        System.out.println("OverridingPrivate30.g()");
    }
}

public class Test720 {
    public static void main(String[] args){
        OverridingPrivate20 oPrivate = new OverridingPrivate20();
        //  oPrivate.f();
        //  oPrivate.g();
    }

}
