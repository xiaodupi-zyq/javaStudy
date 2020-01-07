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

    /**
     * 选择排序
     * @param a
     */
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

    /**
     * 归并排序
     * @param a
     */
    public static void mergeSort(int[] a){
        //调用
        mergeSortC(a,0,a.length-1);
    }

    /**
     * 递归函数实现分而治之这个过程
     * @param a
     * @param start
     * @param end
     */
    public static void mergeSortC(int[] a,int start,int end){
        //判断是否此时只有一个元素，递归终止条件
        if(start >= end){
            return;
        }
        //找到数组中间元素下标
        int mid = (start + end)/2;
        //递归左分
        mergeSortC(a,start,mid);
        //递归右分
        mergeSortC(a,mid+1,end);
        //两者合并
        merge(a,start,mid,end);
    }

    /**
     * 将两个分开的数组合并成一个数组，放回原数组位置
     * @param a
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(int[] a,int left,int mid,int right){
        int[] tmp = new int[a.length];
        int p1 = left;
        int p2 = mid + 1;
        int k = left;
        //数据比较，放入新的暂存空间
        while(p1 <= mid && p2 <= right){
            if(a[p1] <= a[p2]){
                tmp[k++] = a[p1++];
            }else{
                tmp[k++] = a[p2++];
            }
        }
        //将有剩余的数组全部放到暂存数组最后
        while (p1 <= mid){
            tmp[k++] = a[p1++];
        }
        while (p2 <= right){
            tmp[k++] = a[p2++];
        }
        //数组拷贝回原来数组
        for(int i = left;i <= right; i++){
            a[i] = tmp[i];
        }
    }

    /**
     * 快速排序
     * @param a
     */
    public static void quickSort(int[] a){
        //调用递归函数
        quickSortC(a,0,a.length-1);
    }

    /**
     * 递归实现分区过程
     * @param a
     * @param start
     * @param end
     */
    public static void quickSortC(int[] a,int start,int end){
        if(start >= end){
            return;
        }
        int mid = partition(a,start,end);
        quickSortC(a,start,mid-1);
        quickSortC(a,mid+1,end);
    }

    /**
     * 将排序分区
     * @param a
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] a,int start,int end){
        //默认最后一个元素是分界区元素
        int pivot = a[end];
        //i为开始的元素
        int i = start;
        //j从开始一直到倒数第二个元素
        for(int j = start; j < end;j++){
            //如果a[j]小于分界点元素，将a[j]放到已处理区间末尾，也就是a[i]处，i往后挪
            if(a[j] < pivot){
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i = i+1;
            }
        }
        //循环完毕后，将默认的最后一个元素也就是分界点与a[i]交换
        int tmp = a[i];
        a[i] = a[end];
        a[end] = tmp;
        return i;
    }

    /**
     * 桶排序
     * @param a
     * @param bucketSize
     */
    public static void bucketSort(int[] a, int bucketSize){
        if(a.length <= 1){
            return;
        }
        //寻找最大最小值
        int min = a[0];
        int max = a[0];
        for (int i = 0; i < a.length;i++){
            if(min > a[i]){
                min = a[i];
            }else if(max < a[i]){
                max = a[i];
            }
        }
        //计算桶间隔
        int bucketCount = (max - min) / bucketSize + 1;
        //创建二维数组做桶
        int[][] buckets = new int[bucketCount][bucketSize];
        //存储每个桶中元素个数
        int[] indexArr = new int[bucketCount];

        //遍历所有数据将数据放入不同的桶中
        for(int i = 0; i < a.length;i++){
            int bucketIndex = (a[i] - min) / bucketSize;
            //扩容
            if(indexArr[bucketIndex] == buckets[bucketIndex].length){
                ensureCapacity(buckets,bucketIndex);
            }
            buckets[bucketIndex][indexArr[bucketIndex]++] = a[i];
        }

        int k = 0;
        for(int i = 0; i < buckets.length;i++) {
            if (indexArr[i] == 0) {
                continue;
            }
            //桶内元素快排
            quickSortC(buckets[i], 0, indexArr[i] - 1);
            //元素复制到原数组中
            for (int j = 0; j < indexArr[i]; j++) {
                a[k++] = buckets[i][j];
            }
        }
    }

    /**
     * 数组扩容
     * @param buckets
     * @param bucketIndex
     */
    public static void ensureCapacity(int[][] buckets,int bucketIndex){
        int[] tempArr = buckets[bucketIndex];
        int[] newArr = new int[tempArr.length * 2];
        for (int j = 0; j < tempArr.length; j++) {
            newArr[j] = tempArr[j];
        }
        buckets[bucketIndex] = newArr;
    }

    /**
     * 计数排序
     * @param a
     */
    public static void countingSort(int[] a){
        if(a.length <= 1){
            return;
        }
        //寻找数据范围
        int max = a[0];
        for(int i = 0; i < a.length; i++){
            if(max < a[i]){
                max = a[i];
            }
        }
        //申请一个数组c，小标是0~max
        int[] c = new int[max + 1];
        //计算每个元素的个数放入到c中
        for(int i = 0; i < a.length;i++){
            c[a[i]]++;
        }
        //依次累加
        for(int i = 1; i < c.length;i++){
            c[i] = c[i-1] + c[i];
        }
        //申请临时数组
        int[] r = new int[a.length];
        //计数排序，从后往前可以保证稳定性
        for(int i = a.length-1; i >= 0;i--){
            r[c[a[i]]-1] = a[i];
            c[a[i]]--;
        }
        //结果拷贝给数组a
        for(int i = 0; i < a.length; i++){
            a[i] = r[i];
        }
    }

    /**
     * 基数排序
     * @param arr
     */
    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 从个位开始，对数组arr按"指数"进行排序
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    /**
     * 变化的计数排序
     * @param arr
     * @param exp
     */
    public static void countingSort(int[] arr, int exp) {
        if (arr.length <= 1) {
            return;
        }

        // 计算每个元素的个数
        int[] c = new int[10];
        for (int i = 0; i < arr.length; i++) {
            c[(arr[i] / exp) % 10]++;
        }

        // 计算排序后的位置
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }

        // 临时数组r，存储排序之后的结果
        int[] r = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            r[c[(arr[i] / exp) % 10] - 1] = arr[i];
            c[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r[i];
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
        System.out.println("---------------");
        a = arrayGenerator(9);
        out(a);
        mergeSort(a);
        out(a);
        System.out.println("---------------");
        a = arrayGenerator(11);
        out(a);
        quickSort(a);
        out(a);
        System.out.println("---------------");
        a = arrayGenerator(20);
        out(a);
        bucketSort(a,5);
        out(a);
        System.out.println("---------------");
        int[] b = {2,5,3,0,2,3,0,3};
        out(b);
        countingSort(b);
        out(b);
        System.out.println("---------------");
        a = arrayGenerator(50);
        out(a);
        countingSort(a);
        out(a);


        System.out.println("---------------");
        int[] c = {1301827233,1283293792,323947393,131312312,23423423};
        out(c);
        radixSort(c);
        out(c);

    }
}
