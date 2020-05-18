package LeetCode;

import java.util.*;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 22:40 2020/2/25
 * @Modified By:
 */



public class SerializeTreeNode {

    int index = -1;
    String Serialize(TreeNode root) {
        StringBuffer s = new StringBuffer();
        ArrayList<String> list = preOrder(root);
        for(String item : list){
            s.append(item + "!");
        }
        return s.toString();
    }
    ArrayList<String> preOrder(TreeNode root){
        ArrayList<String> list = new ArrayList<>();
        if(root == null){
            list.add("#");
            return list;
        }
        list.add(String.valueOf(root.val));
        list.addAll(preOrder(root.left));
        list.addAll(preOrder(root.right));
        return list;
    }
    TreeNode Deserialize(String str) {
        String[] array = str.split("!");
        return reBuild(array);
    }
    TreeNode reBuild(String[] arr){
        index++;
        if(index > arr.length){
            return null;
        }
        TreeNode root = null;
        if(!arr[index].equals("#")){
            root = new TreeNode(Integer.valueOf(arr[index]));
            root.left = reBuild(arr);
            root.right = reBuild(arr);
        }
        return root;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(13);
        root.left = new TreeNode(1234);
        root.right = new TreeNode(34);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new TreeNode(43);
        root.right.right = new TreeNode(324);
        SerializeTreeNode serializeTreeNode = new SerializeTreeNode();
        String str = serializeTreeNode.Serialize(root);
        System.out.println(str);
        TreeNode treeNode = serializeTreeNode.Deserialize(str);
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < 5; i++){
            list.add(new Random().nextInt(100));
        }
        for(int i : list){
            System.out.print(i + " ");
        }
        Collections.sort(list);
        System.out.println();
        for(int i : list){
            System.out.print(i + " ");
        }
    }

}