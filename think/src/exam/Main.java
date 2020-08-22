package exam;

import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = sc.nextInt();
        }
        if(N <= 3){
            for(Integer j : nums){
                System.out.print(j + " ");
            }
            return;
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int k = 1;
        int i = 0;
        while(i < N){
            ArrayList<Integer> tmp = new ArrayList<>();
            int t = k;
            while(t > 0 && i < N){
                tmp.add(nums[i]);
                t--;
                i++;
            }
            k = k << 1;
            list.add(tmp);
        }
        ArrayList<Integer> ret = new ArrayList<>();
        int len = list.size();
        for(int j = 0; j < len - 1;j++){
            ret.add(list.get(j).get(0));
        }
        ret.addAll(list.get(len-1));
        int s = list.get(len-1).size() / 2 ;
        for(int j = s; j < list.get(len - 2).size() - 1;j++){
            ret.add(list.get(len - 2).get(j));
        }
        for(int j = len-2; j > 0; j--){
            int l = list.get(j).size();
            ret.add(list.get(j).get(l-1));
        }
        for(Integer j : ret){
            System.out.print(j + " ");
        }


    }
}

