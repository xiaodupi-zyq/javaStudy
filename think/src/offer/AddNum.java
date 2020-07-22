package offer;

/**
 * @Author: zyq-xiaoliuzi
 * @Description: 进制转换求和
 * @Date: Created in 22:13 2020/6/28
 * @Modified By:
 */
public class AddNum {
    public int Add(int num1,int num2) {
        int result = 0;
        int carry = 0;
        do{
            result = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = result;
            num2 = carry;
        }while(carry != 0);
        return result;
    }
}
