package offer;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 9:38 2020/6/24
 * @Modified By:
 */
public class MoreThanHalfOfNUM {
    public int MoreThanHalfNum_Solution(int[] nums) {
        int majority = nums[0];
        for (int i = 1, cnt = 1; i < nums.length; i++) {
            cnt = nums[i] == majority ? cnt + 1 : cnt - 1;
            if (cnt == 0) {
                majority = nums[i];
                cnt = 1;
            }
        }
        int cnt = 0;
        for (int val : nums)
            if (val == majority)
                cnt++;
        return cnt > nums.length / 2 ? majority : 0;
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,2,2,2,5,4,2};
        MoreThanHalfOfNUM moreThanHalfOfNUM = new MoreThanHalfOfNUM();
        moreThanHalfOfNUM.MoreThanHalfNum_Solution(nums);

    }
}
