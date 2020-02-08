package LeetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: zyq-xiaoliuzi
 * @Description: 按层输出二叉树
 * @Date: Created in 20:39 2020/1/14
 * @Modified By:
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class PrintTreeOfLevel {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList list = new ArrayList();
        if(root == null){
            return list;
        }
        //将根节点加入到队列中
        queue.add(root);
        //队列为空就结束循环
        while(!queue.isEmpty()){
            //取头节点
            TreeNode node = queue.peek();
            //将头节点弹出
            queue.poll();
            //将头节点的元素值加入到列表中
            list.add(node.val);
            //如果头节点有左右子节点就将子节点加入到队列中
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return list;
    }
}
