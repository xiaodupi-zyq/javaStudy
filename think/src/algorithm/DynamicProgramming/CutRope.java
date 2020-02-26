package algorithm.DynamicProgramming;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 22:17 2020/2/26
 * @Modified By:
 */
public class CutRope {
    public int cutRope(int target) {
        int[] mem = new int[target+1];
        mem[0] = 1;
        mem[1] = 1;
        for(int i = 2; i <= target;i++){
            //如果不进行剪切
            if(i != target){
                mem[i] = i;
            }
            //剪切成两段，两个子段的最大值之积就是最大的（只能由这个两段或者不分开得来）
            for(int j = 1; j < i; j++){
                mem[i] = Math.max(mem[i],mem[i-j] * mem[j]);
            }
        }
        return mem[target];
    }
}
