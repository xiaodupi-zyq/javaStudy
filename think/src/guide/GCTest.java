package guide;

import java.util.Arrays;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 20:34 2020/6/4
 * @Modified By:
 */
public class GCTest {
    public static void main(String[] args){
        byte[] allocation1,allocation2;
        allocation1 = new byte[76288*1024];
        allocation2 = new byte[900*1024];
        byte[] pre1 = Arrays.copyOfRange(allocation1,1,11);
    }
}

class ClassLoaderDemo {
    public static void main(String[] args) {
        System.out.println("ClassLodarDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader());
        System.out.println("The Parent of ClassLodarDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader().getParent());
        System.out.println("The GrandParent of ClassLodarDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader().getParent().getParent());
    }
}

class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0){
            return 0;
        }
        int start = 0;
        int end = array.length-1;
        return minNumber(start,end,array);
    }
    public int minNumber(int start,int end,int[] array){
//        if(start == end){
//            return array[start];
//        }
        int mid = (start + end) / 2;
        if(mid == start){
            return array[end];
        }
        if(array[mid] < array[start]){
            return minNumber(start,mid,array);
        }else{
            return minNumber(mid,end,array);
        }
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] array = {3,4,5,1,2};
        int x = solution.minNumberInRotateArray(array);
    }
}
