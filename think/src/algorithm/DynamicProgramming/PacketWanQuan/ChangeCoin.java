package algorithm.DynamicProgramming.PacketWanQuan;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 15:54 2020/8/9
 * @Modified By:
 */
public class ChangeCoin {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        if(amount == 0){
            return 0;
        }
        if(len == 0){
            return 0;
        }
        int[] dp = new int[amount + 1];

        //完全背包问题，与01背包的区别在于，首先物品数不受限制了，可以任意装取，所以反过来也就是在dp数组中的迭代顺序为正序了
        for(int coin : coins){
            for(int i = coin; i <= amount; i++){
                if(i == coin){
                    dp[i] = 1;
                }else if(dp[i] == 0 && dp[i - coin] > 0){
                    dp[i] = dp[i - coin] + 1;
                }else if(dp[i - coin] > 0){
                    dp[i] = Math.min(dp[i],dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}
