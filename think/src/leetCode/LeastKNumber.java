package LeetCode;

import algorithm.Sort.Sort;

import java.util.ArrayList;

public class LeastKNumber {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> output = new ArrayList<>();
        if(k > input.length){
            for(int i = 0; i < input.length;i++){
                output.add(input[i]);
            }
            return output;
        }
        quickSort(input);
        for(int i = 0; i < k;i++){
            output.add(input[i]);
        }
        return output;
    }
    public void quickSort(int[] a){
        quickSortC(a,0,a.length-1);
    }
    public void quickSortC(int[] a,int start,int end){
        if(start >= end){
            return;
        }
        int mid = partition(a,start,end);
        quickSortC(a,start,mid-1);
        quickSortC(a,mid+1,end);
    }
    public int partition(int[] a,int start,int end){
        int pivot = a[end];
        int i = start;

        for(int j = start; j < end; j++){
            if(a[j] < pivot){
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i = i + 1;
            }
        }
        int tmp = a[i];
        a[i] = pivot;
        a[end] = tmp;
        return i;
    }

    public static void main(String[] args){
        int[] a = Sort.arrayGenerator(1);
        Sort.out(a);
        LeastKNumber leastKNumber = new LeastKNumber();
        leastKNumber.quickSort(a);
        Sort.out(a);
        ArrayList list = leastKNumber.GetLeastNumbers_Solution(a,1);
        System.out.println(list);

    }
}
