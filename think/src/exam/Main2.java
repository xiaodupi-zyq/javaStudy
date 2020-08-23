package exam;

import java.util.Scanner;


public class Main2 {

    public static int dropValue(int[] nums){
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        int sum = 0;
        for(int i = 0; i < len; i++){
            sum += nums[i];
        }
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
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
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

    }
}
