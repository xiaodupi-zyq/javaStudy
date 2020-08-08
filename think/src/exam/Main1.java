package exam;

import java.util.*;

public class Main1 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] nums = new int[M];
        for(int i = 0; i < M; i++){
            nums[i] = sc.nextInt();
        }
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i = 0; i < M; i++){
            list.add(nums[i]);
        }
        list.add(N + 1);
        int pos = 0;
        for(int i = 1; i <= N; i++){
            if(list.contains(i)){
                continue;
            }else{
                for(int j = pos; j < list.size(); j++){
                    if(list.get(j) > i){
                        list.add(j,i);
                        break;
                    }
                }
            }
        }

        list.remove(list.size() - 1);
        for(int i = 0; i < N; i++){
            System.out.print(list.get(i) + " ");
        }

    }
}

