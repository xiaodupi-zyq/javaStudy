package offer;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 19:51 2020/6/29
 * @Modified By:
 */
public class Duplicate {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length == 0){
            return false;
        }
        int i = 0;
        while(i < length){
            if(numbers[i] == i){
                i++;
                continue;
            }else{
                if(numbers[numbers[i]] == numbers[i]){
                    duplication[0] = numbers[i];
                    return true;
                }else{
                    int tmp = numbers[i];
                    numbers[i] = numbers[numbers[i]];
                    // numbers[numbers[i]] = tmp;//numbers[i]已经发生了变化，此时做交换是错误的
                    numbers[tmp] = tmp;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        Duplicate duplicate = new Duplicate();
        int[] a = {2,3,1,0,2,5,3};
        int[] b = new int[1];
        System.out.println(duplicate.duplicate(a,a.length,b));

    }
}
