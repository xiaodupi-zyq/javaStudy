package offer;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 20:05 2020/7/9
 * @Modified By:
 */
public class GetMedian {
    PriorityQueue<Integer> little = new PriorityQueue<>((o1,o2)-> o2 - o1);
    PriorityQueue<Integer> large = new PriorityQueue<>();
    public void Insert(Integer num) {
        little.add(num);
        if(little.size() - large.size() <= 1){
            if(large.size() == 0){
                return;
            }
            if(little.peek() > large.peek()){
                int tmp = little.poll();
                little.add(large.poll());
                large.add(tmp);
            }
        }else {
            large.add(little.poll());
        }
    }

    public Double GetMedian() {
        if(little.size() == large.size()){
            return (Double.valueOf(little.peek()) + Double.valueOf(large.peek())) / 2;
        }else{
            return Double.valueOf(little.peek());
        }
    }

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> ret = new ArrayList<>();
        if(num.length < size){
            return ret;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1,o2) -> o2-o1);
        for(int i = 0; i < num.length;i++){
            if(heap.size() == size){
                ret.add(heap.peek());
                heap.remove(num[i - size]);
            }
            heap.add(num[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        GetMedian median = new GetMedian();
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        //[5,2,3,4,1,6,7,0,8]
        while(sc.hasNextInt()){
            median.Insert(sc.nextInt());
            System.out.println(median.GetMedian());
        }
//        int[] a = {5,2,3,4,1,6,7,0,8};
//        for(int it : a){
//            median.Insert(it);
//            System.out.println(median.GetMedian());
//        }
        int[] b = {2,3,4,2,6,2,5,1};
        ArrayList<Integer> ret = median.maxInWindows(b,3);

    }
}
