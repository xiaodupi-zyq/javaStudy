package exam;
<<<<<<< HEAD
import java.util.*;
=======

import java.util.Scanner;
>>>>>>> origin/master


public class Main2 {

    public static int[] ratato(int x,int r,int c,int n,int m){
        int t = x % 4;
        int[] ret = new int[4];
        if(t == 0){
            ret[0] = r;
            ret[1] = c;
            ret[2] = n;
            ret[3] = m;
        }else if(t == 1){
            ret[0] = c;
            ret[1] = n - r + 1;
            ret[2] = m;
            ret[3] = n;
        }else if(t == 2){
            ret[0] = n - r + 1;
            ret[1] = m - c + 1;
            ret[2] = n;
            ret[3] = m;
        }else if(t == 3){
            ret[0] = m - c + 1;
            ret[1] = r;
            ret[2] = m;
            ret[3] = n;
        }
        return ret;
    }
    public static int[] back(int x,int r,int c,int n,int m){
        int t = x % 2;
        int[] ret = new int[4];
        if(t == 0){
            ret[0] = r;
            ret[1] = c;
            ret[2] = n;
            ret[3] = m;
        }else{
            ret[0] = r;
            ret[1] = m - c + 1;
            ret[2] = n;
            ret[3] = m;
        }
<<<<<<< HEAD
        return ret;
=======
        boolean[][] dp = new boolean[len][sum + 1];
        dp[0][0] = true;
        dp[0][nums[0]] = true;
        for(int i = 1; i < len; i++){
            for(int j = 0; j <= sum; j++){
                dp[i][j] = dp[i - 1][j];
                if(j >= nums[i]){
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        int value = 0;
        for(int i = sum; i >= 0; i--){
            if(i % 2 == 0){
                if(dp[len - 1][i] && dp[len - 1][i / 2]){
                    value = sum - i;
                    break;
                }
            }
        }
        return value;
>>>>>>> origin/master
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
<<<<<<< HEAD
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        for(int i = 0; i < q;i++){
            int r = sc.nextInt();
            int c = sc.nextInt();
            int[] change1 = ratato(x,r,c,n,m);
            int[] change2 = back(y,change1[0],change1[1],change1[2],change1[3]);
=======
        int T = sc.nextInt();
        int N = sc.nextInt();
        int[][] nums = new int[T][N];
        for(int i = 0; i < T; i++){
            for(int j = 0; j < N; j++){
                nums[i][j] = sc.nextInt();
            }
        }
        int[] count = new int[T];
        for(int i = 0; i < T; i++){
//            Arrays.sort(nums[i]);
            count[i] = dropValue(nums[i]);
        }
        for(int i = 0; i < T; i++){
            System.out.print(count[i] + " ");
        }
>>>>>>> origin/master

            int[] change3 = ratato(4 - (z % 4),change2[0],change2[1],change2[2],change2[3]);
            System.out.print(change3[0] + " " + change3[1]);
            System.out.println();
        }
    }
}