package LeetCode;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 15:14 2020/7/24
 * @Modified By:
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        int ret = pathCount(root,sum);
        int left = pathSum(root.left,sum);
        int right = pathSum(root.right,sum);
        return ret + left + right;
    }

    public int pathCount(TreeNode root,int sum){
        if(root == null){
            return 0;
        }
        sum = sum - root.val;
        int ret = sum == 0 ? 1 : 0;
        int left = pathCount(root.left,sum);
        int right = pathCount(root.right,sum);
        return ret + left + right;
    }

}

