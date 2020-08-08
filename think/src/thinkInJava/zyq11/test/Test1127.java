package thinkInJava.zyq11.test;

import java.util.LinkedList;
import java.util.Queue;

class Command{
    private String str = "SWJTU";
    public void operation(){
        System.out.println(str);
    }
}

class Z{
    Queue Co(Queue queue){
        Command c = new Command();
        queue.offer(c);
        return queue;
    }
}

public class Test1127 {
    public static void main(String[] args){
        Z b=new Z();
        Queue<Command> q=new LinkedList<>(); //创建一个队列
        q=b.Co(q); //command c填充到队列中
        q.remove().operation();
    }
}
