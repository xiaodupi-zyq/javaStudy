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
//        System.out.println("---------------");
//        a = arrayGenerator(9);
//        out(a);
//        mergeSort(a);
//        out(a);
//        System.out.println("---------------");
//        a = arrayGenerator(11);
//        out(a);
//        quickSort(a);
//        out(a);
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
