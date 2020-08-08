package exam;

import java.util.Arrays;
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
        return sum;
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
            Arrays.sort(nums[i]);
            count[i] = dropValue(nums[i]);
        }
        for(int i = 0; i < T; i++){
            System.out.print(count[i] + " ");
        }

    }
}
