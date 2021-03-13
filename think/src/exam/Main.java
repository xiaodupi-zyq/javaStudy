package exam;

import java.util.Scanner;

public class Main {

    public static int floorNum(int[] nums,int target,int len){
        int floor = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++){
            if(nums[i] == target){
                return nums[i];
            }
            int t = Math.abs(nums[i] - target);
            if(t < diff){
                floor = nums[i];
                diff = t;
            }else if(diff == t){
                floor = floor <= nums[i] ? floor : nums[i];
            }
        }
        return floor;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        for(int i = 0; i < q; i++){
            int tmp = sc.nextInt();
            int ret = floorNum(nums,tmp,n);
            System.out.println(ret);
        }

    }
}
