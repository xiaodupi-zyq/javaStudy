package algorithm.DynamicProgramming.Profit;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 21:16 2020/8/11
 * @Modified By:
 */

/**
 * 首先定义状态:
 *      dp[i][k][0] => 第i天在交易第k次时没有持有股票
 *      dp[i][k][1] => 第i天在交易第k次时持有股票
 * 理解状态转移方程
 *      “更准确的说 k 的次数可以是买了k次，下面的交易k次用买了k次去理解就会好理解了，买才是一次交易，卖只是完成这次交易”
 *
 *      dp[i][k][0] 该状态只能由 《前一天 已经交易k次 没有持有股票在今天保存不变（dp[i - 1][k][0]）》
 *      和 《 前一天 已经交易k次 持有股票在今天出售（dp[i - 1][k][1] + prices[i]） 得来;
 *      ====> dp[i][k][0] = Max(dp[i - 1][k][0],dp[i - 1][k][1] + prices[i]);
 *
 *      dp[i][k][1] 该状态只能由 《前一天 已经交易k次 持有股票在今天保存不变（dp[i - 1][k][1]）》
 *      和 《 前一天 已经交易k - 1次 没有持有股票在今天买入（dp[i - 1][k - 1][0] - prices[i]） 得来;
 *      ====> dp[i][k][1] = Max(dp[i - 1][k][1],dp[i - 1][k - 1][0] - prices[i]);
 *
 * 初始值；
 *      dp[-1][k][0] = 0
 *      解释：因为 i 是从 0 开始的，所以 i = -1 意味着还没有开始，这时候的利润当然是 0 。
 *      dp[-1][k][1] = -infinity
 *      解释：还没开始的时候，是不可能持有股票的，用负无穷表示这种不可能。
 *      dp[i][0][0] = 0
 *      解释：因为 k 是从 1 开始的，所以 k = 0 意味着根本不允许交易，这时候利润当然是 0 。
 *      dp[i][0][1] = -infinity
 *      解释：不允许交易的情况下，是不可能持有股票的，用负无穷表示这种不可能。
 *
 *      如果无法理解-1，可以直接定义
 *          dp[0][k][0] = 0，在 i = 0时，也就是第一天，可以做交易的情况下，没有持股，所以收益为 0；
 *          dp[0][k][1] = -prices[0], 在 i = 0时，也就是第一天，可以做交易的情况下，持股，所以收益为 -prices[0]；
 *      再来理解 k = 0，此时说明无法做交易，最大交易为 0 次，所有不管是到第几天，此时收益都是0；
 *          dp[i][0][0] = 0;
 *          dp[i][0][1] = -infinity
 *
 */


public class Profit {
    /**
     * 只能买卖一次，获取最大值，更新最小值，以及更新获利的最大值，最后返回
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        /**
         *
         int min = Integer.MAX_VALUE;
         int money = 0;
         int len = prices.length;
         for(int i = 0; i < len; i++){
         if(prices[i] < min){
         min = prices[i];
         }
         if(prices[i] - min > money){
         money = prices[i] - min;
         }
         }
         return money;
         **/

        //dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1] + prices[i])
        //dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0] - prices[i])
        //k = 1;
        //初始化
        int len = prices.length;
        if(len < 2){
            return 0;
        }
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] =  -prices[0];
        for(int i = 1; i < len; i++){
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
            //  k - 1 = 0,所以dp[i-1][k-1][0] - prices[i] = dp[i-1][0][0] = 0;
            dp[i][1] = Math.max(dp[i - 1][1],-prices[i]);
        }
        return dp[len - 1][0];
    }

    /**
     * 可以买卖多次，但是买卖之前必须售出，获取最大值，找到峰值和峰谷，两个值相减即可
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        /**
         int max = 0;
         int start = 0;
         int len = prices.length;
         int end = len - 1;
         int i = 0;
         while(i < len - 1){
         //注意逻辑表达式的截断效应
         while(i < len - 1 && prices[i] >= prices[i + 1]){
         i++;
         }
         start = i;
         while(i < len - 1 && prices[i] < prices[i + 1]){
         i++;
         }
         end = i;
         max += (prices[end] - prices[start]);
         }
         return max;
         **/
        int len = prices.length;
        if (len < 2){
            return 0;
        }
        int[][] dp = new int[len][2];
        /**
         dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1] + prices[i])
         dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0] - prices[i])
         k = inf，所以k == k-1，原始公式简化为
         dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1] + prices[i])
         dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k][0] - prices[i])
         同样都是k，k就没有用途了，可以直接省略了
         dp[i][0] = max(dp[i-1][0],dp[i-1][1] + prices[i])
         dp[i][1] = max(dp[i-1][1],dp[i-1][0] - prices[i])
         **/
        //初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < len; i++){
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];

    }

    /**
     * 可以交易两次，最后得到最大收益
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        /**
         int len = prices.length;
         if(len < 2){
         return 0;
         }

         int[][] dp = new int[len][5];
         /**根据状态转移图来看一共有五种状态，什么都不操作，买第一次，卖第一次，买第二次，卖第二次，且最大值出现在第一，三，五状态中；
         * 初始化，对于第一天来说，什么都不操作，获益是0，买第一次获益是 -prices[0]，在第一天中，后面三者状态不会出现所以后面三者都是MIN_VALUE
         * 初始化可以写成如下
         *
         dp[0][0] = 0;
         dp[0][1] = -prices[0];
         dp[0][2] = Integer.MIN_VALUE;
         dp[0][3] = Integer.MIN_VALUE;
         dp[0][4] = Integer.MIN_VALUE;
         for(int i = 1; i < len; i++){
         //每种状态都只有当前状态不操作，和昨天前一种状态在今天发生了操作得来的
         dp[i][0] = 0;
         dp[i][1] = Math.max(dp[i - 1][1],dp[i][0] - prices[i]);
         dp[i][2] = Math.max(dp[i - 1][2],dp[i][1] + prices[i]);
         dp[i][3] = Math.max(dp[i - 1][3],dp[i][2] - prices[i]);
         dp[i][4] = Math.max(dp[i - 1][4],dp[i][3] + prices[i]);
         }
         return Math.max(Math.max(dp[len - 1][0],dp[len - 1][2]),dp[len - 1][4]);
         **/
        int len = prices.length;
        if(len < 2){
            return 0;
        }
        /**
         * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1] + price[i])
         * dp[i][k][0] = max(dp[i-1][k][1],dp[i-1][k-1][0] - price[i])
         * k = 2;
         */
        //初始化
        int[][][] dp = new int[len][2 + 1][2];

        for(int i = 0; i < len; i++){
            for(int j = 0; j <= 2; j++){
                if(i == 0){
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                if(j == 0){
                    dp[i][j][0] = 0;
                    dp[i][j][1] = Integer.MIN_VALUE;
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0],dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1],dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][2][0];
    }

    /**
     * 最多交易k次，每天只能买卖一次，所以如果交易次数k > n/2则最后等于是无限制的买卖
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit4(int k, int[] prices) {
        int len = prices.length;
        if(len < 2){
            return 0;
        }

        if(k > len / 2){
            /**
             * 无限制买卖，
             */
            int[][] dp = new int[len][2];
            for(int i = 0; i < len; i++){
                if(i == 0){
                    dp[i][0] = 0;
                    dp[i][1] = 0 - prices[0];
                    continue;
                }
                dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] - prices[i]);
            }
            return dp[len-1][0];
        }else{
            int[][][] dp = new int[len][k + 1][2];

            /**
             * 初始化
             * 第一天，无法交易，没有持有股票 dp[0][0][0] = 0;
             * 第一天，无法交易，不允许持有股票，dp[0][0][1] = -inf;//不可能出现这种情况
             * 第一天，可以交易(k > 0),没有持有股票，dp[0][k][0] = 0;//没有股票收益为0；
             * 第一天，可以交易(k > 0),持有股票，dp[0][k][1] = -price[0];//没有股票收益为0；
             */
            for(int i = 0; i < len;i++){
                for(int j = 0; j <= k; j++){
                    if(i == 0){
                        dp[i][j][0] = 0;
                        dp[i][j][1] = -prices[0];
                        continue;
                    }
                    if(j == 0){
                        dp[i][j][0] = 0;
                        dp[i][j][1] = Integer.MIN_VALUE;
                        continue;
                    }
                    dp[i][j][0] = Math.max(dp[i - 1][j][0],dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1],dp[i - 1][j - 1][0] - prices[i]);
                }
            }
            return dp[len-1][k][0];
        }
    }

    /**
     * 无限次卖出，加一天冷冻期
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2){
            return 0;
        }
        /**
         * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1] + prices[i])
         * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0] - prices[i])
         * k = inf,所以 k-1 == k
         * dp[i][0] = max(dp[i-1][0],dp[i-1][1] + prices[i])
         * dp[i][1] = max(dp[i-1][1],dp[i-1][0] - prices[i])
         * 冷冻期，所以
         * dp[i][1] = max(dp[i-1][1],dp[i-2][0] - prices[i])
         */
        //初始化
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        int dp_pre = 0;
        for(int i = 1; i < len; i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp_pre - prices[i]);
            dp_pre = dp[i - 1][0];
        }
        return dp[len - 1][0];
    }

    /**
     * 无限次买，有费率
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if(len < 2){
            return 0;
        }
        /**
         * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1] + prices[i])
         * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0] - prices[i])
         * k = inf,所以 k-1 == k
         * dp[i][0] = max(dp[i-1][0],dp[i-1][1] + prices[i])
         * dp[i][1] = max(dp[i-1][1],dp[i-1][0] - prices[i])
         * 有费率，所以
         * dp[i][0] = max(dp[i-1][0],dp[i-1][1] + prices[i] - fee)
         */
        //初始化
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < len; i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }

}
