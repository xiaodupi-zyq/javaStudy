package thinkInJava.zyq11;

import java.util.*;

public class PriorityQueueDemo {
    public static void main(String[] args){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Random rand = new Random(47);
        for(int i = 0; i < 10; i++){
            priorityQueue.offer(rand.nextInt(i + 10));
        }
        QueueDemo.printQ(priorityQueue);//此时的输出有优先级，最小的值有最高的优先级

        List<Integer> ints = Arrays.asList(25,22,20,18,14,9,3,1,1,2,3,9,14,18,23,25);
        priorityQueue = new PriorityQueue<>(ints);
        QueueDemo.printQ(priorityQueue);
        priorityQueue = new PriorityQueue<>(ints.size(), Collections.reverseOrder());
        priorityQueue.addAll(ints);
        QueueDemo.printQ(priorityQueue);
    }
}
