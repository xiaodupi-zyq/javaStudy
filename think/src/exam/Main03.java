package exam;

import java.util.Scanner;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 12:56 2020/8/9
 * @Modified By:
 */

public class Main03 {

    public static void main(String[] args) {
        new Main03().start();
    }
    private int result;
    private void start(){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0){
            //当前轮的结果
            result = Integer.MAX_VALUE;
            //n个礼物
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int[] state = new int[n];
            //对于一个礼物有3种状态 要么分给A -1 要么给B -2 要么就不分 -3
            dfs(0,state,arr);
            System.out.println(result);
        }
    }
    private void dfs(int index,int state[],int[] arr){
        //分配完了 开始判断
        if(index == state.length){
            //如果A和B价值相等就直接更新丢弃值
            int valOfA = 0,valOfB = 0,valOfOut = 0;
            for(int i = 0;i < state.length;i++){
                if(state[i] == 1){
                    valOfA += arr[i];
                }else if(state[i] == 2){
                    valOfB += arr[i];
                }else if(state[i] == 3){
                    valOfOut += arr[i];
                }
            }
            //统计完毕
            if(valOfA == valOfB)result = Math.min(result,valOfOut);
            return;
        }
        //开始分配
        state[index] = 1;
        dfs(index + 1,state,arr);
        state[index] = 2;
        dfs(index + 1,state,arr);
        state[index] = 3;
        dfs(index + 1,state,arr);
    }

}
