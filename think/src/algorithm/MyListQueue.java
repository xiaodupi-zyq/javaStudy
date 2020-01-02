package algorithm;

public class MyListQueue {
    private Node head;
    private Node tail;
    private int n;
    private int count = 0;

    //初始化
    public MyListQueue(int capacity){
        head = tail = new Node();
        n = capacity;
    }

    //入队
    public boolean enqueue(int item){
        if(count == n){
            return false;
        }
        tail.data = item;
        tail.next = new Node();
        tail = tail.next;
        count++;
        return true;
    }

    //出队
    public String dequeue(){
        if(count == 0){
            return null;
        }
        Node p = head;
        head = head.next;
        count--;
        return p.data+"";
    }

    public void out(){
        Node p = head;
        System.out.print("head: " + head.data + " ");
        System.out.print("count: " + count + " -> ");
        while (p != tail){
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        MyListQueue myListQueue = new MyListQueue(5);
        for(int i = 0; i < 6; i++){
            myListQueue.enqueue(i);
        }
        myListQueue.out();
        myListQueue.dequeue();
        myListQueue.out();
        myListQueue.dequeue();
        myListQueue.out();
        myListQueue.dequeue();
        myListQueue.out();
        myListQueue.dequeue();
        myListQueue.out();
        myListQueue.dequeue();
        myListQueue.out();
        myListQueue.enqueue(5);
        myListQueue.out();
        myListQueue.enqueue(6);
        myListQueue.out();
        myListQueue.enqueue(7);
        myListQueue.out();
        myListQueue.dequeue();
        myListQueue.out();

    }
}
