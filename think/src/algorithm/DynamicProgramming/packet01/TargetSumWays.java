package algorithm.DynamicProgramming.packet01;

/**
 * @Author: zyq-xiaoliuzi
 * @Description: 01背包问题的dfs解法，如果加上剪枝就会更快
 * @Date: Created in 14:02 2020/8/9
 * @Modified By:
 */
public class TargetSumWays {
    int count = 0;
    public int findTargetSumWays_dfs(int[] nums, int S) {
        dfs(nums,0,S);
        return count;
    }
    public void dfs(int[] nums,int index,int S){
        if(index == nums.length){
            if(S == 0){
                count++;
            }
            return;
        }
        dfs(nums,index+1,S - nums[index]);
        dfs(nums,index+1,S + nums[index]);
    }

    /**
     * 动态规划
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
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
                // if(j - nums[i - 1] >= 0){
                //     //j + nums[i - 1]
                //     if(j + nums[i - 1] <= sum){
                //         dp[i][j] = dp[i -1][j - nums[i -1]] + dp[i - 1][j + nums[i -1]];
                //     }else{
                //         dp[i][j] = dp[i -1][j - nums[i -1]];
                //     }
                // }else{
                //     if(j + nums[i - 1] <= sum){
                //         //和为负数跟和为正数的种类一样多
                //         dp[i][j] = dp[i -1][nums[i -1] - j] + dp[i - 1][j + nums[i -1]];
                //     }else{
                //         dp[i][j] = dp[i -1][nums[i -1] - j];
                //     }
                // }
                if(j + nums[i - 1] <= sum){
                    //和为负数跟和为正数的种类一样多
                    dp[i][j] = dp[i -1][Math.abs(j - nums[i -1])] + dp[i - 1][j + nums[i -1]];
                }else{
                    dp[i][j] = dp[i -1][Math.abs(j - nums[i -1])];
                }
            }
        }

        return S >= 0 ? dp[nums.length][S] : dp[nums.length][-S];
    }
}
