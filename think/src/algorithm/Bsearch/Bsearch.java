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

    /**
     * 寻找第一个等于给定值的元素
     * @param a
     * @param value
     * @return
     */
    public int fristItem(int[] a,int value){
        int low = 0;
        int high = a.length - 1;
        while(low <= high){
            int mid = low + ((high - low) >> 1);
            if(a[mid] > value){
                high = mid - 1;
            }else if(a[mid] < value){
                low = mid + 1;
            }else {
                if(mid == 0 || a[mid - 1] != value) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个等于给定值的函数
     * @param a
     * @param value
     * @return
     */
    public int lastItem(int[] a, int value){
        int low = 0;
        int high = a.length - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if(a[mid] > value){
                high = mid - 1;
            }else if(a[mid] < value){
                low = mid + 1;
            }else {
                if(mid == a.length - 1 || a[mid + 1] != value) {
                    return mid;
                }else {
                    low = mid + 1;
                }
            }
        }
        return  -1;
    }

    /**
     * 第一个大于等于给定值的元素
     * @param a
     * @param value
     * @return
     */
    public int fristGEItem(int[] a,int value){
        int low = 0;
        int high = a.length - 1;
        while(low <= high){
            int mid = low + ((high - low) >> 1);
            if(a[mid] < value){
                low = mid + 1;
            }else {
                if(mid == 0 || a[mid - 1] < value){
                    return mid;
                }else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 最后一个小于等于给定值的元素
     * @param a
     * @param value
     * @return
     */
    public int lastLEItem(int[] a,int value){
        int low = 0;
        int high = a.length - 1;
        while(low <= high){
            int mid = low + ((high - low) >> 1);
            if(a[mid] > value){
                high = mid - 1;
            }else {
                if(mid == a.length - 1 || a[mid + 1] > value){
                    return mid;
                }else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public int search1(int[] nums, int target){
        return search1(nums,0,nums.length - 1, target);
    }

    public int search1(int[] nums,int low,int high,int target){
        if(low > high){
            return -1;
        }
        int mid = low + ((high - low) >> 2);
        if(nums[mid] == target){
            return mid;
        }
        if(nums[mid] >= nums[low]){
            if(target >= nums[low] && target < nums[mid]){
                return search1(nums,low,mid - 1,target);
            }else {
                return search1(nums,mid + 1,high,target);
            }
        }else {
            if(target <= nums[high] && target > nums[mid]){
                return search1(nums,mid + 1,high,target);
            }else {
                return search1(nums,low,mid - 1,target);
            }
        }
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

        System.out.println("--------------------------------");

        int[] b = {1,3,4,5,8,8,8,8,8,18};
        System.out.println(bsearch.fristItem(b,8));
        System.out.println(bsearch.lastItem(b,8));

        System.out.println("--------------------------------");
        int[] c = arrayGenerator(20);
        out(c);
        Sort.quickSort(c);
        out(c);
        System.out.println(bsearch.fristGEItem(c,25) + " " + c[bsearch.fristGEItem(c,25)]);

        System.out.println("--------------------------------");
        c = arrayGenerator(20);
        out(c);
        Sort.quickSort(c);
        out(c);
        System.out.println(bsearch.lastLEItem(c,25) + " " + c[bsearch.lastLEItem(c,25)]);

        System.out.println("--------------------------------");
        int[] nums = {3,1};
        int target = 1;
        System.out.println(bsearch.search1(nums,target));


    }

}
