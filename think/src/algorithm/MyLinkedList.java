package algorithm;

class Node{
    int data;
    Node next;
    Node(int data) {
        this.data = data;
    }
}

public class MyLinkedList {
    private Node head;
    private Node last;
    private int size;

    /**
     * 插入结点
     * @param data
     * @param index
     * @throws Exception
     */
    public void insert(int data, int index) throws Exception{
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        Node insertedNode = new Node(data);
        if(size == 0){  //空表插入
            head = insertedNode;
            last = insertedNode;
        }else if(index == 0){ //头部插入
            insertedNode.next = head;
            head = insertedNode;
        }else if(index == size) { //尾部插入
            last.next = insertedNode;
            last = insertedNode;
        }else { //中间插入
            Node preNode = get(index -1);
            insertedNode.next = preNode.next;
            preNode.next = insertedNode;
        }
        size++;
    }

    /**
     * 查找结点
     * @param index
     * @return
     */
    public Node get(int index) throws Exception{
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 删除结点
     * @param index
     * @return
     * @throws Exception
     */
    public Node remove(int index) throws Exception{
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        Node removeNode = null;
        if(index == 0) {
            removeNode = head;
            head = head.next;
        }else if(index == size-1){
            Node prevNode = get(index - 1);
            removeNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        }else {
            Node prevNode = get(index -1);
            Node nextNode = prevNode.next.next;
            removeNode = prevNode.next;
            prevNode = nextNode;
        }
        size--;
        return removeNode;
    }

    public void ouput() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws Exception{
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert(3,0);
        myLinkedList.insert(7,1);
        myLinkedList.insert(9,2);
        myLinkedList.insert(5,3);
        myLinkedList.insert(6,1);
        myLinkedList.remove(0);
        myLinkedList.ouput();
    }
}
