package offer;

/**
 * @Author: zyq-xiaoliuzi
 * @Description: 二叉搜索树转换成双向链表，递归写法；
 * @Date: Created in 20:33 2020/6/23
 * @Modified By:
 */
public class TreeConvertToList {
    private TreeNode pre = null;
    private TreeNode head = null;
    public TreeNode Convert(TreeNode pRootOfTree){
        inOrder(pRootOfTree);
        return head;
    }
    public void inOrder(TreeNode node){
        //如果node为null则返回
        if(node == null){
            return;
        }
        //一直向下递归直到不再有左子树，也就是搜索树中最小的节点的左子树（此时为空，直接返回）
        inOrder(node.left);
        //如果有左子树就在上面一直递归，当走出上面一行左子树递归的时候，此时的node就是最左下的节点就是头结点
        if(head == null){
            head = node;
        }
        //确定左子树是前节点
        node.left = pre;
        //如果前节点不为空，则它的右指针应该指向他的父节点
        if(pre != null){
            pre.right = node;
        }
        //左子树遍历之后，前节点往上移动到父节点，记录此时的前节点，然后再转换右节点
        pre = node;
        //转换右节点
        inOrder(node.right);
    }
}
