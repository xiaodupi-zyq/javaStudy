package leetCode;

/**
 * @Author: zyq-xiaoliuzi
 * @Description: 二级制中1的个数
 * @Date: Created in 11:41 2020/1/10
 * @Modified By:
 */
public class NumOf1 {
    public int NumberOf1(int n) {
        String str = Integer.toBinaryString(n);
        String[] strArr = str.split("");
        int count = 0;
        for(int i = 0; i < strArr.length;i++){
            if(strArr[i].equals("1")){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        NumOf1 numOf1 = new NumOf1();
        System.out.println(numOf1.NumberOf1(-1234));
    }
}
