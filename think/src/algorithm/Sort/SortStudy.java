package algorithm.Sort;

import java.util.Random;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 22:20 2020/7/21
 * @Modified By:
 */
public class SortStudy {
    /**
     * 生成随意数组
     * @param n
     * @return
     */
    public static int[] arrayGenerator(int n){
        int [] a = new int[n];
        Random random = new Random();
        for(int i = 0; i < n; i++){
            a[i] = random.nextInt(50);
        }
        return a;
    }

    /**
     * 数组输出
     * @param a
     */
    public static void out(int[] a){
        StringBuffer string = new StringBuffer();
        for(int i = 0; i < a.length; i++){
            string.append(a[i] + " ");
        }
        System.out.println(string.toString());
    }

    /**
     * 冒泡排序，第一层控制冒泡次数，第二层控制相邻元素之间的交换。
     * @param a
     */
    public static void bubbleSort(int[] a){
        if(a.length < 2){
            return;
        }
        for(int i = 0; i < a.length;i++){
            for(int j = 0; j < a.length - i - 1;j++){
                if(a[j] > a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
    }

    /**
     * 插入排序
     * @param a
     */
    public static void insertionSort(int[] a){
        if(a.length < 2){
            return;
        }
        for(int i = 1; i < a.length; i++){
            int val = a[i];
            int j = i - 1;
            for(; j >= 0; j--){
                if(a[j] > val){
                    a[j + 1] = a[j];
                }else{ //找到比val值小的位置放进去
                    break;
                }
            }
            a[j + 1] = val;
        }
    }

    /**
     * 选择排序
     * @param a
     */
    public static void selectionSort(int[] a){
        if(a.length < 2){
            return;
        }
        for(int i = 0; i < a.length; i++){
            int index = i;
            for(int j = i + 1; j < a.length; j++){
                if(a[j] < a[index]){
                    index = j;
                }
            }
            int tmp = a[i];
            a[i] = a[index];
            a[index] = tmp;
        }
    }

    /**
     * 归并排序
     * @param a
     */
    public static void mergeSort(int[] a){
        int start = 0;
        int end = a.length - 1;
        mergeSortC(a,start,end);

    }
    public static void mergeSortC(int[] a,int start,int end){
        if(start >= end){
            return;
        }
        int mid = (start + end) /2;
        mergeSortC(a,start,mid);
        mergeSortC(a,mid+1,end);
        merge(a,start,mid,end);
    }
    public static void merge(int[] a,int start,int mid,int end){
        int[] b = new int[a.length];
        int q = start;
        int p = mid+1;
        int k = start;
        while(q <= mid && p <= end){
            if(a[q] <= a[p]){
                b[k++] = a[q++];
            }else{
                b[k++] = a[p++];
            }
        }
        while(q <= mid){
            b[k++] = a[q++];
        }
        while(p <= end){
            b[k++] = a[p++];
        }
        for(int i = start; i <= end; i++){
            a[i] = b[i];
        }
    }

    public static void quickSort(int[] a){
        quickSortC(a,0,a.length-1);
    }
    public static void quickSortC(int[] a,int start,int end){
        if(start >= end){
            return;
        }
        int mid = partition(a,start,end);
        quickSortC(a,start,mid-1);
        quickSortC(a,mid+1,end);
    }
    public static int partition(int[] a,int start,int end){
        int val = a[end];
        int i = start;
        //将所有小于a[end]的数字移到前面
        for(int j = start; j < end; j++){
            if(a[j] < val){
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
            }
        }
        int tmp = a[i];
        a[i] = a[end];
        a[end] = tmp;
        return i;
    }



    public static void main(String [] args){
        int[] a = arrayGenerator(10);
        out(a);
        bubbleSort(a);
        out(a);
        System.out.println("---------------");
        a = arrayGenerator(10);
        out(a);
        insertionSort(a);
        out(a);
        System.out.println("---------------");
        a = arrayGenerator(10);
        out(a);
        selectionSort(a);
        out(a);
        System.out.println("---------------");
        a = arrayGenerator(10);
        out(a);
        mergeSort(a);
        out(a);
        System.out.println("---------------");
        a = arrayGenerator(11);
        out(a);
        quickSort(a);
        out(a);
//        System.out.println("---------------");
//        a = arrayGenerator(20);
//        out(a);
//        bucketSort(a,5);
//        out(a);
//        System.out.println("---------------");
//        int[] b = {2,5,3,0,2,3,0,3};
//        out(b);
//        countingSort(b);
//        out(b);
//        System.out.println("---------------");
//        a = arrayGenerator(50);
//        out(a);
//        countingSort(a);
//        out(a);
//
//
//        System.out.println("---------------");
//        int[] c = {1301827233,1283293792,323947393,131312312,23423423};
//        out(c);
//        radixSort(c);
//        out(c);

    }
}
