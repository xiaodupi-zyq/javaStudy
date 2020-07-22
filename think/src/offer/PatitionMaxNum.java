package offer;

import java.util.Scanner;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 19:18 2020/7/18
 * @Modified By:
 */
public class PatitionMaxNum {
    public static int MaxNum(int number){

        char[] c =(number+"").toCharArray();

        for (int i = 0; i < c.length; i++) {
            //找到最大数字的位置
            int flag = i;
            for (int j = i; j < c.length; j++) {
                if(c[j]>c[flag]){
                    flag = j;
                }
            }
            //判断最大值的位置是不是i;是则不换，否则换并return
            if(flag != i){
                char[]  result = swap(c, i,flag);
                String str = result[0]+"";
                for(int j = 1; j < result.length; j++) {
                    str += result[j];
                }
                return Integer.parseInt(str);
            }
        }

        return number;

    }
    static char[] swap(char[] c, int i,int j){
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
        return c;
    }




    public static void main(String[] args) {
//        int data =326591;//1234
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            System.out.println(MaxNum(array[i]));
        }


    }
}
