package algorithm.Sort;

import java.util.Random;

public class Sort {

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
        if(a.length <= 1){
            return;
        }
        for(int i = 0; i < a.length;i++){ //控制冒泡次数
            boolean flag = false; //增加判断条件，如果已经排序好了及时停止。
            for(int j = 0; j < a.length - i -1; j++){
                if(a[j] > a[j+1]){ //只有a[j] > a[j+1]才会交换位置，等于是不加交换的，保证稳定性
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag) break;
        }
    }

    /**
     * 插入排序
     * @param a
     */
    public static void insertionSort(int[] a){
        for(int i = 1; i < a.length; i++){
            int value = a[i]; //记录数据，防止在数据移动过程中被覆盖
            int j = i - 1; //记录空位，即插入位置，在最后可以直接插入
            for(; j >= 0; j--){
                if(a[j] > value){
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }

    public static void selectionSort(int [] a){
        for(int i = 0; i < a.length; i++){//遍历数组中所有的位置
            int min = i;//默认该位置上的现有的数就是未排序区最小的
            for(int j = i + 1; j < a.length;j++){//向后遍历
                if(a[j] < a[min]){ //找出更小的数
                    min = j; //记录下标
                }
            }
            int temp = a[i];  //交换位置
            a[i] = a[min];
            a[min] = temp;
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

    }
}
