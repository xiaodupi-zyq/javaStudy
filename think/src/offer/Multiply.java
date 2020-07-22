package offer;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 20:47 2020/6/29
 * @Modified By:
 */
public class Multiply {
    public int[] constructArr(int[] a) {
        int len = a.length;
        int[] b = new int[len];
        int t = 1;
        for(int i = 0; i < len;i++){
            if(i == 0){
                b[i] = t;
                t = t * a[i];
            }else{
                t = t * a[i-1];
                b[i] = t;
            }
        }
        t = 1;
        for(int i = len-1; i >= 0; i--){
            if(i == len - 1){
                b[i] = t * b[i];
            }else{
                t = t * a[i + 1];
                b[i] = t * b[i];

            }
        }
        return b;
    }
    //一来一去
    public static void main(String[] args){
        int[] a = {1,2,3,4,5};
        Multiply multiply = new Multiply();
        multiply.constructArr(a);
    }
}
