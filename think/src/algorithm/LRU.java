package algorithm;

import java.util.ArrayList;
import java.util.HashMap;

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

    public void delete(Node pre) {
        if (pre.next == null) {
            return;
        } else {
            pre.next = pre.next.next;
        }
    }
}

class LRUCache {
    private ArrayList<Integer> list;
    private HashMap<Integer,Integer> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if(map.keySet().contains(key)){
            list.remove((Integer) key);
            list.add(key);
            return map.get(key);
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.keySet().contains(key)){
            list.remove((Integer) key);
            list.add(key);
            map.put(key,value);
        }else{
            if(list.size() == capacity){
                map.remove(list.get(0));
                list.remove(0);
            }
            list.add(key);
            map.put(key,value);
        }
    }
    public static void main(String[] args){
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(2, 2);
        cache.get(2);
        cache.put(1, 1);
        cache.put(4, 1);
        cache.get(1);

    }
}
