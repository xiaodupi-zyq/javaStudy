package zyq11;

import java.util.Iterator;
import java.util.LinkedList;


public class Stack {
    private LinkedList<String> storage = new LinkedList<>();
    public void push(String v){
        storage.addFirst(v);
    }
    public String peek() {
        return storage.getFirst();
    }
    public String pop() {
        return storage.removeFirst();
    }
    public boolean empty(){
        return storage.isEmpty();
    }
    public String toString(){
        return storage.toString();
    }

}
