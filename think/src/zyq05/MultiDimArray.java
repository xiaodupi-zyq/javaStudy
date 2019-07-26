package zyq05;

import java.util.Random;

public class MultiDimArray {
    static Random rand = new Random();
    static int pRand(int mod){
        return Math.abs(rand.nextInt()) % mod + 1;
    }
    public static void main(String[] args) {
        int [] [] a1 = {
                {1, 2, 3},
                {4, 5, 6},
        };
        for (int i = 0 ; i < a1.length; i++){
            for (int j = 0; j < a1[i].length; j++) {
                System.out.println(a1[i][j]);
            }
        }

    }
}
