package LeetCode;

import java.util.Scanner;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 15:05 2020/7/25
 * @Modified By:
 */
public class GoldCoin {
    public static void main(String[] args){
        StringBuffer st = new StringBuffer();
        st.delete(0,st.length());
        
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] T = new int[M][N];
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                T[i][j] = sc.nextInt();
            }
        }
    }
}
