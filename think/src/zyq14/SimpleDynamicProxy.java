package zyq14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler implements InvocationHandler{
    private Object proxied;
    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**** proxy: " + proxy.getClass() + ", method: " +method + ", args: " + args);
        if(args != null) {
            for (Object arg : args) {
                System.out.println(" " + args);
            }
        }
        return method.invoke(proxied,args);
    }
}

public class SimpleDynamicProxy {
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.SomthingElse("bonobo");
    }
    public static void main(String[] args){
        RealObject real = new RealObject();
        consumer(real);
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader()/*一个类的加载器*/,new Class[] {Interface.class}/*一个你希望该代理实现的接口列表*/,new DynamicProxyHandler(real)/*以及一个InvocationHandler接口的实现*/);
        consumer(proxy);
    }
}
//todo:动态代理
