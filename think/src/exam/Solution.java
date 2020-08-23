package exam;

public class Solution {

    public static boolean canPartition(int[] nums) {
        int len = nums.length;
        if(len <= 1){
            return false;
        }
        int sum = 0;
        for(int i = 0; i < len; i++){
            sum += nums[i];
        }
        if(sum % 2 == 1){
            return false;
        }
        boolean[][] dp = new boolean[len][sum / 2 + 1];
        //初始化
        dp[0][0] = true;
        if(nums[0] <= sum / 2){
            dp[0][nums[0]] = true;
        }
        //动态规划。只能用上一行的结果去做下一行的结果，否则是要出问题的，这才符合子问题原则
        for(int i = 1; i < len; i++){
            for(int j = 0; j < sum / 2 + 1; j++){
                dp[i][j] = dp[i - 1][j];
                if(j >= nums[i]){
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        if(dp[len - 1][sum / 2]){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        int[] a = {1,2,5};
        System.out.println(canPartition(a));
    }
}