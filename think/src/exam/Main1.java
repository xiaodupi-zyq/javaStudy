package exam;

import java.util.*;

public class Main1 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] nums = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                nums[i][j] = sc.nextInt();
            }
        }
        ArrayList<Integer> sum = new ArrayList<>();
        for(int i = 0; i < M; i++){
            int s = 0;
            for(int j = 0; j < N; j++){
                s += nums[j][i];
            }
            sum.add(s);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < M; i++){
            ArrayList<Integer> tmp = new ArrayList<>(sum);
            Collections.rotate(tmp,i);
            int s = 0;
            int m = Integer.MIN_VALUE;
            for(int j = 0; j < M; j++){
                s += tmp.get(j);
                m = s > m ? s : m;
                if(s < 0){
                    s = 0;
                }
            }
            max = max > m ? max : m;
        }
        System.out.println(max);




    }
}

