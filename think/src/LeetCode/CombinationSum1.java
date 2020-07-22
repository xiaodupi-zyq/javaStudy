package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 22:30 2020/3/15
 * @Modified By:
 */

/**
 * 回溯问题，套路就是：走错不可怕，及时回头，回头过程要把错走的节点及时清掉
 */
public class CombinationSum1 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Stack<Integer> path = new Stack<>();
        Arrays.sort(candidates);
        int len = candidates.length;
        dfs(candidates,len,0,path,target);
        return result;
    }
    public void dfs(int[] candidates,int len,int start,Stack<Integer> path,int target){
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0){
            return;
        }
        for(int i = start; i < len;i++){
            path.push(candidates[i]);
            dfs(candidates,len,i,path,target-candidates[i]);
            path.pop();
        }
    }
    public static void main(String[] args){
        CombinationSum1 solution1 = new CombinationSum1();
        int[] nums = {2,3,6,7};
        solution1.combinationSum(nums,7);



    }
}
