package LeetCode;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 23:26 2020/3/11
 * @Modified By:
 */
public class MaxSumAndProduct {
    /**
     * 最大连续子序列之和：在循环中判断前面元素和是否小于0，小于0则候选子序列从当前元素开始。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length;i++){
            if(sum > 0){
                sum += nums[i];
            }else{
                sum = nums[i];
            }
            if(sum > max){
                max = sum;
            }
        }
        return max;
    }

    /**
     * 最大连续子序列之积：在循环中判断目前元素是否大于0，如果小于0将会发生最大值和最小值的反转，所以提前进行调换，
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int Max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i],nums[i]);
            imin = Math.min(imin * nums[i],nums[i]);
            Max = Math.max(Max, imax);
        }
        return Max;
    }
}
