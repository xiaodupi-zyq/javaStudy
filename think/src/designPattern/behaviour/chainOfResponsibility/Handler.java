package designPattern.behaviour.chainOfResponsibility;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 10:48 2020/8/7
 * @Modified By:
 */
public abstract class Handler {
    protected Handler successor;

    public Handler(Handler successor){
        this.successor = successor;
    }
    protected abstract void handleRequest(Request request);
}

class ConCreteHandler1 extends Handler{
    public ConCreteHandler1(Handler successor) {
        super(successor);
    }

    @Override
    protected void handleRequest(Request request) {
        if(request.getType() == RequestType.TYPE1){
            System.out.println(request.getName() + " is handle by ConcreteHandler1");
            return;
        }
        if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

class ConCreteHandler2 extends Handler{
    public ConCreteHandler2(Handler successor) {
        super(successor);
    }

    @Override
    protected void handleRequest(Request request) {
        if(request.getType() == RequestType.TYPE2){
            System.out.println(request.getName() + " is handle by ConcreteHandler2");
            return;
        }
        if (successor != null) {
            successor.handleRequest(request);
        }
    }
}


class Request {

    private RequestType type;
    private String name;


    public Request(RequestType type, String name) {
        this.type = type;
        this.name = name;
    }


    public RequestType getType() {
        return type;
    }


    public String getName() {
        return name;
    }
}

enum RequestType {
    TYPE1, TYPE2
}



