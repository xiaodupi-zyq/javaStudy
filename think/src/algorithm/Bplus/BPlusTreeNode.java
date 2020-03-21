package algorithm.Bplus;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 11:19 2020/3/13
 * @Modified By:
 */

/**
 * B+树非叶子节点定义
 * 假设keywords = {3,5,8,10}
 * 4个键值将数据指向5个空间，(-inf,3),(3,5),(5,8),(8,10),(10,inf)
 * m值是实现计算好的，计算的依据就是让所有信息的大小正好等于页的大小
 * PAGE_SIZE = (m-1)*4[keywords大小] + m*8[children大小]
 */
public class BPlusTreeNode {
    public static int m = 5;
    public int[] keywords = new int[m-1];//键值
    public BPlusTreeNode[] children = new BPlusTreeNode[m];//指针
}
/**
 * B+树叶子节点定义
 * B+树的叶子节点和内部的节点不一样，叶子节点存储的是值
 * k值事先计算好的，计算的依据就是让所有信息的大小正好等于页的大小
 * PAGE_SIZE = (k)*4[keywords大小] + k*8[dataAd..大小]+8[prev大小]+8[next大小]
 */
class BPlusTreeLeafNode{
    public static int k = 3;
    public int[] keywords = new int[k];
    public long[] dataAddress = new long[k];
    public BPlusTreeNode prev;
    public BPlusTreeNode next;
}
