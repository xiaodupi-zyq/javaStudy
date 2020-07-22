package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 15:41 2020/7/19
 * @Modified By:
 */
public class FindLongestTree {
    public static int[] findLongestTree(int[] array){
        if(array.length == 0){
            return new int[]{1, 50};
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 != 0){
                list1.add(array[i]);
            }else{
                list2.add(array[i]);
            }
        }
        if(list1.size() == 0){
            return new int[]{1, 50};
        }
        if(list2.size() == 0){
            return new int[]{2, 50};
        }
        int max = 0;
        int count = 0;
        int start = 1;
        for(int i = 1; i <= 100; i = i+2){
            if(list1.contains(i) ){
                max = count > max ? count : max;
                count = 0;
                start = i + 2;
            }else{
                count++;
            }
        }
        max = count > max ? count : max;
        count = 0;
        for(int i = 2; i <= 100; i = i+2){
            if(list2.contains(i) ){
                //todo
                max = count > max ? count : max;
                count = 0;
                start = i + 2;
            }else{
                count++;
            }
        }
        max = count > max ? count : max;
        int[] ret = {start,max};
        return ret;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[N];
        for(int i = 0; i < N; i++){
            array[i] = sc.nextInt();
        }
        System.out.println(findLongestTree(array)[0]);
        System.out.println(findLongestTree(array)[1]);

    }
}
