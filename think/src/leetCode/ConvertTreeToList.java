package leetCode;

import java.util.ArrayList;

/**
 * @Author: zyq-xiaoliuzi
 * @Description: 将二叉树变成双向链表
 * @Date: Created in 22:07 2020/1/15
 * @Modified By:
 */
public class ConvertTreeToList {
        public TreeNode Convert(TreeNode pRootOfTree) {
            if(pRootOfTree == null){
                return null;
            }
            if(pRootOfTree.left == null && pRootOfTree.right == null){
                return pRootOfTree;
            }
            ArrayList<TreeNode> list = new ArrayList<TreeNode>();
            list = inOrder(pRootOfTree);

            for(int i = 0; i < list.size();i++){
                if(i == 0){
                    list.get(i).left = null;
                    list.get(i).right = list.get(i+1);
                    continue;
                }
                if(i == list.size()-1){
                    list.get(i).left = list.get(i-1);
                    list.get(i).right = null;
                    continue;
                }
                list.get(i).left = list.get(i-1);
                list.get(i).right = list.get(i+1);
            }
            return list.get(0);
        }
        public ArrayList<TreeNode> inOrder(TreeNode pRootOfTree){
            ArrayList<TreeNode> list = new ArrayList<TreeNode>();
            if(pRootOfTree == null){
                return list;
            }
            list.addAll(inOrder(pRootOfTree.left));
            list.add(pRootOfTree);
            list.addAll(inOrder(pRootOfTree.right));
            return list;
        }
}
