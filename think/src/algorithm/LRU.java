package algorithm;

public class LRU {
    private Node head;
    private Node last;
    private int size;

    public void insertHead(Node node){
        node.next = head;
        head = node;
    }

    public Node search(int target){
        Node pre = new Node(0);
        pre.next = head;
        Node flag = head;
        while(flag.next != null){
            if(target == flag.data){
                break;
            }
            pre = flag;
            flag = flag.next;
        }
        return pre;
    }

    public void delete(Node pre){
        if(pre.next == null){
            return;
        }else{
            pre.next = pre.next.next;
        }
    }
}
