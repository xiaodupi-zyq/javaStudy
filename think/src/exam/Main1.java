package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    private static List<List<Integer>> res = new ArrayList<List<Integer>>();
    private static List<Integer> temp = new ArrayList<>();

    public static List<List<Integer>> find(int[] nums){
        if(nums == null){
            return null;
        }
        dfs(0,Integer.MIN_VALUE,nums);
        return res;
    }

    private static void dfs(int curIndex,int preValue,int[] nums){
        if(curIndex >= nums.length){
            if(temp.size() >= 2){
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        if(nums[curIndex] >= preValue){
            temp.add(nums[curIndex]);
            dfs(curIndex + 1,nums[curIndex],nums);
            temp.remove(temp.size() - 1);
        }
        if(nums[curIndex] != preValue){
            dfs(curIndex + 1,preValue,nums);
        }
    }



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n < 3){
            System.out.println(0);
            return;
        }
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }

        List<List<Integer>> ret = find(nums);
        int count = 0;
        for(List<Integer> list : ret){
            if(list.size() == 0){
                count++;
            }
        }
        System.out.println(count);



    }
}

