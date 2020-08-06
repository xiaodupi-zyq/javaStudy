package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 14:23 2020/7/23
 * @Modified By:
 */
public class FindTargetSum {
    public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(S > sum || S < -sum){
            return 0;
        }
        int[][] dp = new int[nums.length + 1][sum + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= nums.length; i++){
            for(int j = 0; j <= sum; j++){
                if(j - nums[i - 1] >= 0){
                    //j + nums[i - 1]
                    if(j + nums[i - 1] <= sum){
                        dp[i][j] = dp[i -1][j - nums[i -1]] + dp[i - 1][j + nums[i -1]];
                    }else{
                        dp[i][j] = dp[i -1][j - nums[i -1]];
                    }
                }else{
                    if(j + nums[i - 1] <= sum){
                        dp[i][j] = dp[i -1][nums[i -1] - j] + dp[i - 1][j + nums[i -1]];
                    }else{
                        dp[i][j] = dp[i -1][nums[i -1] - j];
                    }
                }
            }
        }

        return S >= 0 ? dp[nums.length][S] : dp[nums.length][-S];
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(nums[i] == i+1){
                continue;
            }else{
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for(int i = 0; i < len; i++){
            System.out.println(nums[i]);
        }
        for(int i = 0; i < len; i++){
            if(nums[i] != i+1){
                ret.add(i + 1);
            }
        }
        return ret;
    }

    public static void main(String[] args){
        int[] a = {0,0,0,0,0,0,0,0,1};
        System.out.println(findTargetSumWays(a,1));
        int[] b = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(b));
    }
}