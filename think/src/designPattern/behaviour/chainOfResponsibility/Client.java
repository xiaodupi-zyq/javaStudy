package designPattern.behaviour.chainOfResponsibility;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 11:05 2020/8/7
 * @Modified By:
 */
public class Client {
    public static void main(String[] args){
        /**
         * handler2 -> handler1,构成一个责任链，如果请求在handler2中解决不了，会继续传递往下倒handler1
         */
        Handler handler1 = new ConCreteHandler1(null);
        Handler handler2 = new ConCreteHandler2(handler1);

        Request request1 = new Request(RequestType.TYPE1,"request1");
        handler2.handleRequest(request1);

        Request request2 = new Request(RequestType.TYPE2,"request2");
        handler2.handleRequest(request2);


    }
}