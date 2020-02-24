package algorithm.DynamicProgramming;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 18:14 2020/2/24
 * @Modified By:
 */
public class MinDistence {
    private int minDist = Integer.MIN_VALUE;

    /**
     * 回溯算法求最短距离
     * @param i 第i行
     * @param j 第j列
     * @param dist 到此的最短距离
     * @param w 棋盘
     * @param n 最后目的
     */
    public void minDistBT(int i,int j,int dist,int[][] w,int n){
        if(i == n && j == n){
            if(dist < minDist){
                minDist = dist;
                return;
            }
        }
        if(i < n){//往下走
            minDistBT(i + 1,j,dist+w[i][j],w,n);
        }
        if(j < n){//往右走
            minDistBT(i,j+1,dist+w[i][j],w,n);
        }
    }

    /**
     * 动态规划求距离（状态转移表法）
     * @param matrix 棋盘
     * @param n 要求位置
     * @return
     */
    public int minDistDP(int[][] matrix,int n){
        int[][] states = new int[n][n];
        int sum = 0;
        for(int j = 0; j < n; j++){
            sum += matrix[0][j];
            states[0][j] = sum;
        }
        sum = 0;
        for(int i = 0; i < n; i++){
            sum += matrix[i][0];
            states[i][0] = sum;
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                states[i][j] = matrix[i][j] + Math.min(states[i][j - 1],states[i - 1][j]);
            }
        }
        return states[n-1][n-1];
    }

    private int[][] matrix = {{1,3,5,9},{2,1,3,4},{5,2,6,7},{6,8,4,3}};
    private int n = 4;
    private int[][] mem = new int[n][n];

    public int minDistDP1(int i,int j){
        if(i == 0 && j == 0){
            return matrix[0][0];
        }
        if(mem[i][j] > 0) return mem[i][j];
        int minLeft = Integer.MAX_VALUE; //便于比较,使用最大值
        if(j - 1 >= 0){
            minLeft = minDistDP1(i,j-1);
        }
        int minUp = Integer.MAX_VALUE;
        if(i - 1 >= 0){
            minUp = minDistDP1(i-1,j);
        }
        int currMinDist = matrix[i][j] + Math.min(minLeft,minUp);
        mem[i][j] = currMinDist;
        return currMinDist;
    }
}
