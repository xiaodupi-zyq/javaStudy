package guide;

import java.util.Arrays;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 16:09 2020/8/3
 * @Modified By:
 */
interface Formula1{


    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
interface Formula2{

    default double sqrt(int a) {
        return Math.sqrt(a)+100;
    }
}

public class TestDefault implements Formula1,Formula2{
    @Override
    public double sqrt(int a) {
        return Formula1.super.sqrt(a);
    }

    public static void main(String[] args){
        System.out.println(new TestDefault().sqrt(100));
        int[] a = {1,3,45,2};
        Arrays.sort(a);
    }
}
