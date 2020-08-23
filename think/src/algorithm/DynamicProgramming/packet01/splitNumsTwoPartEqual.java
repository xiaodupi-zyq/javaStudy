package algorithm.DynamicProgramming.packet01;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * //给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * //
 * // 注意:
 * //
 * //
 * // 每个数组中的元素不会超过 100
 * // 数组的大小不会超过 200
 * //
 * //
 * // 示例 1:
 * //
 * // 输入: [1, 5, 11, 5]
 * //
 * //输出: true
 * //
 * //解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * //
 * //
 * //
 * //
 * // 示例 2:
 * //
 * // 输入: [1, 2, 3, 5]
 * //
 * //输出: false
 * //
 * //解释: 数组不能分割成两个元素和相等的子集.
 *
 *
 *
 * @Date: Created in 13:09 2020/8/9
 * @Modified By:
 */
public class splitNumsTwoPartEqual {
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
        boolean[] dp = new boolean[sum / 2 + 1];
        //初始化
        dp[0] = true;
//        if(nums[0] <= sum / 2){
//            dp[nums[0]] = true;
//        }
        //动态规划。只能用上一行的结果去做下一行的结果，否则是要出问题的，这才符合子问题原则
//        for(int i = 1; i < len; i++){
//            for(int j = 0; j < sum / 2 + 1; j++){
//                dp[i][j] = dp[i - 1][j];
//                if(j >= nums[i]){
//                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i]];
//                }
//            }
//        }
        //从后往前找的话，可以在保持数组是上一行结构的情况下，节约空间
        for(int i = 0; i < len; i++){
            for(int j = sum / 2; j >= nums[i]; j--){
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }

        if(dp[sum / 2]){
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
