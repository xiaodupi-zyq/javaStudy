package algorithm.Bsearch;

import algorithm.Sort.Sort;

import java.util.Random;

public class Bsearch {
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

    public int bsearch(int[] a,int value){
        int low = 0;
        int high = a.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(a[mid] == value){
                return mid;
            }else if(a[mid] < value){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int bsearch1(int[] a,int value){
        return bsearchInternally(a,0,a.length-1,value);
    }
    private int bsearchInternally(int[] a,int low,int high,int value){
        if(low > high) return -1;
        int mid = low + ((high - low) >> 1);

        if(a[mid] == value) {
            return mid;
        }else if(a[mid] < value){
            return bsearchInternally(a,mid+1,high,value);
        }else {
            return bsearchInternally(a,low,mid-1,value);
        }
    }

    /**
     * 求平方根
     * @param a
     * @return
     */
    public float sqrt(float a){
        if(a == 1.0f){
            return a;
        }
        float low = 0;
        float high = a;
        float mid = (low + high) / 2;

        while(mid * mid - a > 1e-6 || a - mid * mid > 1e-6){
            if(mid * mid > a){
                high = mid;
                mid = (low + high) / 2;
            }else{
                low = mid;
                mid = (low + high) / 2;
            }
        }
        return mid;

    }

    public static void main(String[] args){
        int[] a = {19,27,8,45,11,67,55,98,33,23};
        out(a);
        Sort.quickSort(a);
        out(a);
        Bsearch bsearch = new Bsearch();
        System.out.println(bsearch.bsearch(a,55));
        System.out.println(bsearch.bsearch1(a,55));
        System.out.println(bsearch.sqrt(1.004f));
        System.out.println(bsearch.sqrt(2));
        System.out.println(bsearch.sqrt(3));
        System.out.println(bsearch.sqrt(25));
        System.out.println(bsearch.sqrt(7));

    }

}
