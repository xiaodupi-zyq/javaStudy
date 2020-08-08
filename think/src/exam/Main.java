package exam;

import java.util.*;

public class Main {

    public static Long splitNum(Long num){
        if(num == 1){
            return 0l;
        }
        if(num == 2 || num == 3){
            return 1l;
        }
        Long cnt = num / 2;
        return cnt;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Long[] nums = new Long[N];
        for(int i = 0; i < N; i++){
            nums[i] = sc.nextLong();
        }
        Long count = 0l;
        for(int i = 0; i < N; i++){
            count += splitNum(nums[i]);
        }
        System.out.println(count);

    }
}

