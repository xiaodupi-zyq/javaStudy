package algorithm.heap;

public class Heap {
    private int [] a;//数组从下标1开始存储数据
    private int n; //堆可以存储的最大数据个数
    private int count; //堆中已经存储的数据个数

    /**
     * 构造函数
     * @param capacity
     */
    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    /**
     * 交换数据
     * @param a
     * @param x
     * @param y
     */
    public static void swap(int[] a,int x,int y){
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    /**
     * 堆数据的插入
     * @param data
     */
    public void insert(int data){
        if(count >= n){
            return ;
        }

        ++count;
        a[count] = data;
        int i = count;
        while(i / 2 > 0 && a[i] > a[i / 2]){ //自上而下的堆化
            swap(a,i,i/2); //swap交换函数
            i = i / 2;
        }
    }

    /**
     * 删除堆顶元素
     */
    public void removeMax(){
        if (count == 0){
            return;
        }
        a[1] = a[count];
        --count;
        heapify(a,count,1);
    }

    /**
     * 自上而下的堆化过程
     * @param a
     * @param n
     * @param i
     */
    public static void heapify(int[] a, int n, int i){
        while(true){
            int maxPos = i;
            if(i*2 <= n && a[i] < a[i * 2]) maxPos = i * 2;
            if(i*2+1 <= n && a[i] < a[i*2 +1]) maxPos = i*2+1;

            if(maxPos == i) break;
            swap(a,i,maxPos);
            i = maxPos;
        }
    }

    /**
     * 建堆
     * @param a
     * @param n
     */
    public static void bulidHeap(int[] a,int n){
        for(int i = n/2; i >= 1; --i){
            heapify(a,n,i);
        }
    }

    /**
     * 排序
     * @param a
     * @param n
     */
    public static void sort(int[] a,int n){
        bulidHeap(a,n);
        int k = n;
        while(k > 1){
            swap(a,1,k);
            --k;
            heapify(a,k,1);
        }

    }








}
