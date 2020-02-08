package LeetCode;

/**
 * @Author: zyq-xiaoliuzi
 * @Description: 一个数组是按后序遍历的，判断是否可以构成树
 * @Date: Created in 21:12 2020/1/15
 * @Modified By:
 */
public class SequenceBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        return isBST(sequence,0,sequence.length - 1);
    }
    public boolean isBST(int[] sequence,int start,int end){
        //说明中间的元素都是合适的，已经遍历到最小单元了
        if(start >= end){
            return true;
        }
        //找到中间元素
        int tmp = sequence[end];
        int split = start;
        //找到左右子树分界点，且已经保证前面的数肯定小于分界点
        for(;split < end && sequence[split] < tmp;split++);
        //判断后面的元素是否大于分界点元素，出现小于分界点元素，就返回false
        for(int i = split;i < end; i++){
            if(sequence[i] < tmp) {
                return false;
            }
        }

        //继续判断前后两段的是否正确
        return isBST(sequence,start,split-1)
                && isBST(sequence,split,end - 1);
    }
}
