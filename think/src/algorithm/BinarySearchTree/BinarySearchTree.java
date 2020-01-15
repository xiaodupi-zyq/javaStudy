package algorithm.BinarySearchTree;

/**
 * @Author: zyq-xiaoliuzi
 * @Description: 二叉树
 * @Date: Created in 9:19 2020/1/15
 * @Modified By:
 */
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

}
