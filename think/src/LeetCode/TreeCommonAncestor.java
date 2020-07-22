package LeetCode;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 23:44 2020/3/25
 * @Modified By:
 */
public class TreeCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果当前节点是null或者p或者q返回当前节点
        if(root == null || root.val == p.val || root.val == q.val){
            return root;
        }
        //搜索左子树
        TreeNode left = lowestCommonAncestor(root.left, p,q);
        //返回如果不是null也不是p或者q，就说明已经找到了，直接返回
        if(left != null && left != p && left != q){
            return left;
        }
        //搜索右子树
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        //返回如果不是null也不是p或者q，就说明已经找到了，直接返回
        if(right != null && right != p && right != q){
            return right;
        }
        //如果左子树也不为null，右子树也不为null就返回root
        if(left != null && right != null){
            return root;
        }else{
            return left == null ? right : left;
        }
    }
}
