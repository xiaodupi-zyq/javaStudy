package algorithm;

import java.util.Random;

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }


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
        if(head == null){
            return ;
        }
        Node1 p = head;
        Node1 q = head.node;
        p.node = null;
        while(q != null){
            Node1 tmp = q;
            q = q.node;
            tmp.node = p;
            p = tmp;
        }
        head = p;
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

    /**
     * 查找倒数第K个节点
     * @param k
     * @return
     */
    public Node1 FindKthToTail(int k) {
        Node1 p = head;
        Node1 q = head;
        int i = 0;
        for( ;p!=null ;i++){
            if(i >= k){
                q = q.node;
            }
            p = p.node;
        }
        return i < k? null:q;
    }

    public void deleteLastNNode(int n){
        if(n <= 0){
            return;
        }
        Node1 p ;
        Node1 q = new Node1();
        q.node = p = head;
        int i = 0;
        for(;p!=null;i++){
            if(i >= n){
                q = q.node;
            }
            p = p.node;
        }

        if(i < n){
            return;
        }else{
            if(q.node == head){
                head = head.node;
            }else{
                q.node = q.node.node;
            }
        }


    }


    /**
     * 寻链表中间点
     * @return
     */
    public Node1 middle(){
        Node1 p = head;
        Node1 q = head;
        while(p.node != null && p.node.node != null){
            p = p.node.node;
            q = q.node;
        }
        return q;
    }

    /**
     * 寻找两个链表的第一公共节点
     * @param pHead1
     * @param pHead2
     * @return
     */
    public Node1 FindFirstCommonNode(Node1 pHead1, Node1 pHead2) {
        Node1 p1 = pHead1;
        Node1 p2 = pHead2;
        if(p1 == null || p2 == null){
            return null;
        }
        while(p1 != p2){
            p1 = p1.node;
            p2 = p2.node;
            if(p1 != p2){
                if(p1 == null){
                    p1 = pHead2;
                }
                if(p2 == null){
                    p2 = pHead1;
                }
            }
        }
        return p1;
    }

    /**
     * 将链表重新排列成，L0-Ln-L1-Ln-1 。。。。的形式
     * @param head
     */
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode p = head;
        while(p.next != null && p.next.next != null){
            ListNode q = getEnd(p);
            q.next = p.next;
            p.next = q;
            p = q.next;
        }
    }
    public ListNode getEnd(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = head;
        ListNode q = new ListNode(Integer.MIN_VALUE);
        q.next = p;
        while(p.next != null){
            p = p.next;
            q = q.next;
        }
        q.next = null;
        return p;
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

        System.out.println("倒数第n个结点：");
        System.out.println(myLinked.FindKthToTail(1).c);


        System.out.println("删除倒数第n个结点：");
        myLinked.deleteLastNNode(5);
        myLinked.out();

    }
}
