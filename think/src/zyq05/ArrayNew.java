package zyq05;

import java.util.Random;

public class ArrayNew {
    static Random rand = new Random();
    static int pRand(int mod) {
        return Math.abs(rand.nextInt()) % mod + 1;
    }
    public static void main(String[] args) {
//        int [] a;
//        a = new int[pRand(20)];
        Integer[] a = new Integer[pRand(20)]; //创建句柄数组
//        a = new Integer[pRand(20)];
        System.out.println("length of a = " + a.length);
        for (int i = 0; i < a.length;i++){
            a[i] = new Integer(pRand(500));  //使用时创建实际对象
            System.out.println("a[" + i + "] = " + a[i]);
        }
    }
}
