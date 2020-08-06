package LeetCode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 15:04 2020/7/25
 * @Modified By:
 */
public class ZeroArray {
    public static boolean isZeroArray(int[] nums){
        int len = nums.length;
        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                int sum = 0;
                for(int k = i; k <= j; k++){
                    sum += nums[k];
                }
                if(sum == 0){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = sc.nextInt();
        }
        int count = 0;
        for(int i = 0; i < N;i++){
            for(int j = i + 1; j <= N; j++){
                if(!isZeroArray(Arrays.copyOfRange(nums,i,j))){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
