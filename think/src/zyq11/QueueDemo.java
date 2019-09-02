package zyq11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class QueueDemo {
    public static void printQ(Queue queue){
//        System.out.println(queue);
        while(queue.peek() != null){
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        Random rand = new Random(47);
        for (int i = 0; i < 10; i++){
            queue.offer(rand.nextInt(i + 10)); //插入队列尾部
        }
       printQ(queue);
        Queue<Character> qc = new LinkedList<>();
        for(char c : "Brontosaurus".toCharArray()){
            qc.offer(c);

        }
        printQ(qc);
    }
}
