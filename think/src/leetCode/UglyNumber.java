package LeetCode;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 20:55 2020/2/21
 * @Modified By:
 */
public class UglyNumber {
    /**
     * 注意穷举方法
     * @param index
     * @return
     */
    public int getNUglyNumber(int index){
        if(index == 0){
            return 0;
        }
        int[] result = new int[index];
        result[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        for(int i = 1; i < index; i++){
            result[i] = Math.min(Math.min(result[index2] * 2 , result[index3] * 3),result[index5] * 5);
            if(result[i] == result[index2] * 2) {
                index2++;
            }
            if(result[i] == result[index3] * 3) {
                index3++;
            }
            if(result[i] == result[index5] * 5) {
                index5++;
            }
        }
        return result[index - 1];
    }
    public static void main(String[] args){
        UglyNumber uglyNumber = new UglyNumber();
        System.out.println(uglyNumber.getNUglyNumber(4));
    }
}
