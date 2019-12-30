package algorithm;

/**
 * 栈实现
 */
public class MyStack {
    //链式栈实现
    private Node head;
    private Node last;
    private int size;
    private int count;
    //栈的初始化
    public MyStack(int n){
        this.head = new Node();
        this.last = new Node();
        head.next = last;
        this.size = n;
        this.count = 0;
    }
    //out
    public void out(){
        System.out.print("head: " + this.head.data + " ");
        System.out.print("last: " + this.last.data + " ");
        System.out.print("count: " + this.count + " -> ");
        Node p = this.head;
        while (p != null){
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }
    //出栈
    public boolean pop(){
        if(count == 0){
            return false;
        }
        if(count == 1){
            head = null;
            return true;
        }
        Node p = head;
        while(p.next != this.last){
            p = p.next;
        }
        last = p;
        last.next = null;
        --count;
        return true;
    }

    //入栈
    public boolean push(int item){
        if(count == size){
            return false;
        }
        Node p = new Node(item);
        p.next = null;
        if(count == 0){
            head = p;
            last = p;
        }else{
            last.next = p;
            last = p;
        }
        count++;
        return true;
    }


    public static void main(String[] args){
        MyStack myStack = new MyStack(10);
        for(int i = 0; i < 5; i++){
            myStack.push(i);
        }
        myStack.out();
        myStack.pop();
        myStack.out();
        myStack.pop();
        myStack.out();
        myStack.pop();
        myStack.out();
        myStack.pop();
        myStack.out();

    }
}
