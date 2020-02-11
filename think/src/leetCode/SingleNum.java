package LeetCode;

/**
 * @Author: zyq-xiaoliuzi
 * @Description: 数组A中只有一个数字出现一次，其余数字都出现三次或两次，用线性时间复杂度的算法找出出现一次的数字
 * @Date: Created in 21:10 2020/2/11
 * @Modified By:
 */
public class SingleNum {
    /**
     * 数组A中只有一个数字出现一次，其余数字都出现三次
     * ，用线性时间复杂度的算法找出出现一次的数字
     * @param A
     * @return
     */
    public int singleNumberFromThree(int[] A){
        int a = 0;//记录每个数字出现次数
        int b = 0;//a,b联合起来记录数字位上1出现数字的次数，当a和b对应位上组成的数字满3进一
        for(int c : A){
            //abc的真值表达式
            int resultA = (~a&b&c) | (a&~b&~c);
            int resultB = (~a&~b&c) | (~a&b&~c);
            a = resultA;
            b = resultB;
        }
        return b;
    }

    public int singleNumberFromTwo(int[] A){
        int result = 0;
        for(int a : A){
            result ^= a;
        }
        return result;
    }
}
