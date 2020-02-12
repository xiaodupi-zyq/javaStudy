package algorithm.Str;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 16:53 2020/2/12
 * @Modified By:
 */
public class AcNode {
    public char data;//节点的值
    public AcNode[] children = new AcNode[26];//AC自动机的孩子节点数组
    public boolean isEndingChar = false;//是否是结尾字符
    public int length = -1;//结尾字符时，字符串长度
    public AcNode fail;//失败指针
    public AcNode(char data){
        this.data = data;
    }

}

class AcNodeTrie{
    private AcNode root;

    public AcNodeTrie(AcNode root) {
        this.root = root;
    }

    /**
     * 寻找失败节点
     */
    public void buildFailurePointer(){
        Queue<AcNode> queue = new LinkedList<>();
        root.fail = null;
        queue.add(root);
        while(!queue.isEmpty()){
            //遍历Trie树
            AcNode p = queue.remove();
            for(int i = 0; i < 26; i++){
                //依次取p的孩子pc
                AcNode pc = p.children[i];
                //如果pc的孩子节点为空，下一个孩子节点
                if(pc == null) continue;
                //如果p节点是根节点那么失败节点也为根节点
                if(p == root){
                    pc.fail = root;
                }else{
                    //如果p不是根节点，取p的失败节点
                    AcNode q = p.fail;
                    //当q不为null时
                    while(q != null){
                        //取q的失败节点的孩子节点
                        AcNode qc = q.children[pc.data - 'a'];
                        //判断p的孩子节点好失败节点的孩子节点是否相同，相同则找到p孩子节点的失败节点
                        if(qc != null){
                            pc.fail = qc;
                            break;
                        }
                        //否则继续寻找失败节点的失败节点，直到失败节点为null停止
                        q = q.fail;
                    }
                    //如果失败节点是null，就把失败节点对应为根节点
                    if(q == null){
                        pc.fail = root;
                    }
                }
                queue.add(pc);
            }
        }
    }

    /**
     * ac自动机匹配
     * @param text
     */
    public void match(char[] text){
        int n = text.length;
        AcNode p = root;
        for(int i = 0; i < n; ++i){
            int idx = text[i] - 'a';
            while(p.children[idx] == null && p != root){
                p = p.fail; //孩子节点没有办法匹配，找到失败指针继续匹配
            }
            //继续往下匹配
            p = p.children[idx];
            if(p == null) p = root; //如果没有匹配的，从root开始重新匹配
            AcNode tmp = p;
            //打印出可以匹配的模式串
            while(tmp != root){
                if(tmp.isEndingChar == true){
                    int pos = i - tmp.length + 1;
                    System.out.println("匹配起始下标" + pos + "; 长度" + tmp.length);
                }
                tmp = tmp.fail;
            }
        }
    }
}
