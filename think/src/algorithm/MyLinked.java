package algorithm;

import java.util.Random;

public class MyLinked {
    private Node1 head;
    private Node1 last;
    MyLinked() throws Exception{
        this(5);
    }
    MyLinked(int capacity) throws Exception{
        this('a',capacity,false);
    }
    MyLinked(char c,int capacity,boolean random) throws Exception{
        if(capacity <= 0){
            throw new Exception("链表容量不能为空或负");
        }
        char ch = c;
        for(int i = 0; i < capacity; i++){
            Node1 node = new Node1();
            node.c = ch;
            if(!random){
                ch++;
            }else{
                Random rand = new Random();
                ch+=rand.nextInt(5);
            }

            if(i == 0){
                head = node;
                last = node;
            }else{
                last.node = node;
                last = node;
            }

        }
        last.node = null;
    }

    public void out(){
        Node1 p = new Node1();
        p = head;
        while (p != null){
            System.out.print(p.c + " ");
            p = p.node;
        }
        System.out.println();
    }

    public void reverse(){
        Node1 newLast = head;
        Node1 newHead = head;

        Node1 t = head.node;
        while (t != null){
            Node1 node = new Node1();
            node = t;
            t = t.node;
            node.node = newHead;
            newHead = node;
        }
        newLast.node = null; //记得最后链表节点为null
        last = newLast;
        head = newHead;
    }

    //环的检测，快慢指针
    public boolean isCircle(){
        if(head == last){
            return false;
        }
        Node1 p = head;
        Node1 q = head;

        while(q.node != null && q.node.node != null && q != null){
            q = q.node.node;
            p = p.node;
            if(q == p){
                return true;
            }
        }
        return false;
    }

    //有序链表合并
    public MyLinked merge(MyLinked myLinked1,MyLinked myLinked2) throws Exception {
        MyLinked mergeLinked = new MyLinked(1);
        Node1 head1 = myLinked1.head;
        Node1 head2 = myLinked2.head;
        Node1 mergehead = mergeLinked.head;

        while(head1 != null && head2 != null){
            if(head1.c <= head2.c){
                mergehead.node = head1;
                head1 = head1.node;
            }else{
                mergehead.node = head2;
                head2 = head2.node;
            }
            mergehead = mergehead.node;
        }
        if(head1 != null){
            mergehead.node = head1;
            mergeLinked.head = mergeLinked.head.node;
            mergeLinked.last = myLinked1.last;
        }else{
            mergehead.node = head2;
            mergeLinked.head = mergeLinked.head.node;
            mergeLinked.last = myLinked1.last;
        }
        return mergeLinked;
    }

    public void deleteLastNNode(int n){
        Node1 p = new Node1();
        Node1 q = new Node1();
        p.node = q.node = head;
        for(int i = 0; i < n;i++){
            if(p == null){
                System.out.println("链表总长不足： " + n);
                return;
            }
            p = p.node;
        }
        while (p != last){
            p = p.node;
            q = q.node;
        }
        if(q.node == head){
            head = head.node;
            return;
        }
        q.node = q.node.node;

    }

    public Node1 middle(){
        Node1 p = head;
        Node1 q = head;
        while(p.node != null && p.node.node != null){
            p = p.node.node;
            q = q.node;
        }
        return q;
    }



    public static void main(String[] args) throws Exception{
        MyLinked myLinked = new MyLinked(10);
        myLinked.out();

        System.out.println("是否有环：");
        System.out.println(myLinked.isCircle());
        myLinked.last.node = myLinked.head;
        System.out.println(myLinked.isCircle());
        myLinked.last.node = null;

        System.out.println("求链表中间结点：");
        Node1 middle = myLinked.middle();
        System.out.println(middle.c);

        System.out.println("反转链表：");
        myLinked.reverse();
        myLinked.out();

        System.out.println("链表合并：");
        MyLinked myLinked1 = new MyLinked('a',4,true);
        myLinked1.out();
        MyLinked myLinked2 = new MyLinked('c',2,true);
        myLinked2.out();
        MyLinked mergeLinked = new MyLinked(1);
        mergeLinked = myLinked.merge(myLinked1,myLinked2);
        mergeLinked.out();

        System.out.println("删除倒数第n个结点：");
        myLinked.deleteLastNNode(5);
        myLinked.out();

    }
}
