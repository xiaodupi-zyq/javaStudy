package algorithm.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: zyq-xiaoliuzi
 * @Description: 二叉树
 * @Date: Created in 9:19 2020/1/15
 * @Modified By:
 */

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}


public class BinarySearchTree {
  public static class Node{
    private int data;
    private Node left;
    private Node right;

    public Node(int data){
      this.data = data;
    }
  }
  private Node tree;

  public Node find(int data){
    Node p = tree;
    while (p != null){
      if(data < p.data){
        p = p.left;
      }else if(data > p.data){
        p = p.right;
      }else return p;
    }
    return null;
  }

  public void insert(int data){
    if(tree == null){
      tree = new Node(data);
      return;
    }

    Node p = tree;
    while(p != null){
      if(data > p.data){
        if(p.right == null){
          p.right = new Node(data);
          return;
        }
        p = p.right;
      } else { //data < p.data
        if(p.left == null){
          p.left = new Node(data);
          return;
        }
        p = p.left;
      }
    }
  }

  public void delete(int data){
    Node p = tree;
    Node pp = null;
    while(p != null && p.data != data){
      pp = p;
      if(data > p.data){
        p = p.right;
      }else{
        p = p.left;
      }
      if(p == null){
        return;
      }

      //要删除的节点有两个子节点
      if(p.left != null && p.right != null){
        Node minP = p.right;
        Node minPP = p;
        while(minP.left != null){
          minPP = minP;
          minP = minP.left;
        }
        p.data = minP.data;
        p = minP;
        pp = minPP;
      }

      Node child ;
      if(p.left != null) child = p.left;
      else if(p.right != null) child = p.right;
      else child = null;

      if(pp == null) tree = child;
      else if(pp.left == p) pp.left = child;
      else pp.right = child;

    }
  }

  /**
   * 递归方法，中序遍历
   * @param root
   * @return
   */
  public List<Integer> inorderTraversal(Node root) {
    List list = new ArrayList<>();
    if(root == null){
      return list;
    }
    if(root.left != null){
      list.addAll(inorderTraversal(root.left));
    }
    list.add(root.data);
    if(root.right != null){
      list.addAll(inorderTraversal(root.right));
    }
    return list;
  }

  /**
   * 迭代方法遍历，前序遍历
   * @param root
   * @return
   */
  public List<Integer> preorderTraversal(Node root) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    if(root == null){
      return list;
    }
    Stack<Node> stack = new Stack<Node>();
    //将根节点加入到栈中
    stack.push(root);
    //栈不为空时进行循环，弹出栈顶元素，加入列表，再检查是否存在右节点，加入栈内，再检查左节点，加入，就始终可以保证遍历是先序遍历。
    while(!stack.isEmpty()){
      //弹出栈顶元素
      Node tmp = stack.pop();
      //将栈顶元素加入到列表中
      list.add(tmp.data);
      //如果右节点存在，加入站内
      if(tmp.right != null){
        stack.push(tmp.right);
      }
      //如果左节点存在，加入站内
      if(tmp.left != null){
        stack.push(tmp.left);
      }
    }
    return list;
  }

  /**
   * 迭代方式的后序遍历实现
   * @param root
   * @return
   */
  public List<Integer> postorderTraversal(Node root) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    if(root == null){
      return list;
    }
    Stack<Node> stack = new Stack<Node>();
    stack.push(root);
    //记录前面遍历的节点是哪一个
    Node pre = null;
    while(!stack.isEmpty()){
      //下面这种情况，造成到当栈遍历到最底层之后，往回出栈的时候，又入栈，造成死循环
//            Node tmp = stack.pop();
//            if(tmp.right == null && tmp.left == null){
//                list.add(tmp.data);
//                stack.pop();
//            }
//            if(tmp.right != null){
//                stack.push(tmp.right);
//            }
//            if(tmp.left != null){
//                stack.push(tmp.left);
//            }
      //应该在上述情况下，添加一个条件来判断是否子节点已经遍历

      //根节点不能弹出，但要取出
      Node tmp = stack.peek();
      //判断左右节点是否为空，且左右节点是否已经遍历，如果为空要返回加入列表，如果左右节点已经遍历过了也弹出加入到列表。
      if((tmp.right == null && tmp.left == null) ||
              (pre != null && (pre == tmp.left || pre == tmp.right))){
        list.add(tmp.data);
        pre = tmp;
        stack.pop();
      }else{
        //否则就继续往下面遍历
        if(tmp.right != null){
          stack.add(tmp.right);
        }
        if(tmp.left != null){
          stack.add(tmp.left);
        }
      }
    }
    return list;
  }

  /**
   * 迭代方式实现的中序遍历
   * @param root
   * @return
   */
  public List<Integer> inorderTraversal1(Node root) {
    List<Integer> list = new ArrayList<Integer>();
    Stack<Node> stack = new Stack<Node>();
    Node cur = root;
    //判断当前节点，是否为空，栈是否为空
    while(cur != null || !stack.isEmpty()){
      //如果当前节点不为空
      if(cur != null){
        //就把当前节点加入到栈中
        stack.push(cur);
        //当前节点指向左节点
        cur = cur.left;
      }else{
        cur = stack.pop();
        list.add(cur.data);
        cur = cur.right;
      }
    }
    return list;
  }

  /**
   * 求二叉树所有路径表示的数字的和
   * @param root
   * @return
   */
  public int sumNumbers(TreeNode root) {
    int sum = 0;
    if(root == null){
      return sum;
    }
    return preOrderSum(root,sum);
  }

  /**
   * 前序遍历求和，二叉树之后等于左右二叉树之和之和
   * @param root
   * @param sum
   * @return
   */
  public int preOrderSum(TreeNode root,int sum){
    //如果根节点为null，返回0
    if(root == null){
      return 0;
    }
    //否则sum=sum * 10 + 根节点的值
    sum = sum * 10 + root.val;
    //如果左右节点都为null说明节点为叶子节点
    if(root.left == null && root.right == null){
      return sum;
    }
    //否则返回左右节点之和
    return preOrderSum(root.left,sum) + preOrderSum(root.right,sum);
  }

  /**
   * 最大路径和
   * @param root
   * @return
   */
  int maxPath = Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root){
    getMaxPath(root);
    return maxPath;
  }
  public int getMaxPath(TreeNode root){
    if(root == null){
      return 0;
    }
    //如果左右子树有一个对最后的贡献值为负数，肯定要舍弃这个子树的贡献值
    int left = Math.max(0,getMaxPath(root.left));
    int right = Math.max(0,getMaxPath(root.right));
    //记录到目前为止最大的路径
    maxPath = Math.max(maxPath,root.val + left + right);
    return Math.max(left,right) + root.val;
  }

}
