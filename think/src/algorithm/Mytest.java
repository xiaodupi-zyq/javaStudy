package algorithm;

class Node1{
    char c;
    Node1 node;
    Node1(){

    }
    Node1(char c){
        this.c = c;
    }
}

public class Mytest {
    public static void main(String[] args){
        Node1 node1 = new Node1('a');
        Node1 node11 = new Node1('b');
        node1.node = node11;
        Node1 node12 = new Node1('c');
        node11.node = node12;
        Node1 node13 = new Node1('b');
        node12.node = node13;
        Node1 node14 = new Node1('a');
        node13.node = node14;
        node14.node = null;

        Node1 temp = new Node1();
        temp = node1;
        int count = 0;
        for(;temp != null;count++){
            System.out.println(temp.c);
            temp = temp.node;
        }
        System.out.println(count);
        int flag = count / 2;
        Node1 temp1 = new Node1();
        temp1 = node1;
        for(int i = 0; i < flag; i++){
            temp1 = temp1.node;
        }
        System.out.println(temp1.c);




    }
}
