package algorithm.DynamicProgramming;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 16:55 2020/2/15
 * @Modified By:
 */
public class Packet0_1 {
    private int maxW = Integer.MIN_VALUE;
    private int[] weight = {2,2,4,6,3};
    private int n = 5;
    private int w = 9;


    /**
     * f(0,0,a,10,100)
     * @param i 表示考察到那个物品了
     * @param cw 表示当前已经装进去的物品总重量
     * @param items 表示每个物品的重量
     * @param n 表示物品个数
     * @param w 背包重量
     */
    public void f(int i,int cw,int[] items,int n,int w){
        //cw == w表示装满了，i== n表示考察完所以的物品了
        if(cw == w || i == n){
            if(cw > maxW) maxW = cw;
            return;
        }
        f(i+1,cw,items,n,w);
        // 已经超过可以背包承受的重量的时候，就不要再装了
        if(cw + items[i] <= w){
            f(i+1,cw+items[i],items,n,w);
        }
    }
    public static void main(String[] args){
        Packet0_1 p = new Packet0_1();
        int[] a = {2,2,4,6,3};
        p.f(0,0,a,5,9);
        System.out.println(p.maxW);
    }
}

class Packet0_1_1 {
    private int maxW = Integer.MIN_VALUE;
    private int[] weight = {2,2,4,6,3};
    private int n = 5;
    private int w = 9;
    private boolean[][] mem = new boolean[5][10];//5个物品，10个重量

    /**
     * 带备忘录的回溯算法
     * @param i
     * @param cw
     */
    public void f(int i,int cw){
        if(cw == w || i == n){
            if(cw > maxW){
                maxW = cw;
            }
        }
        if(mem[i][cw]) return; //判断是否是重复状态
        mem[i][cw] = true; //及时记录已经访问过的状态
        f(i+1,cw);//第i个物品不放入
        if(cw + weight[i] <= w){
            f(i+1,cw + weight[i]);//第i个物品放入
        }
    }

    /**
     * 动态规划
     * @param weight
     * @param n
     * @param w
     * @return
     */
    public int knapsack(int[] weight,int n,int w){
        boolean[][] states = new boolean[n][w+1]; //默认为false
        states[0][0] = true; //第一行数据特殊处理
        if(weight[0] <= w){
            states[0][weight[0]] = true;
        }
        for(int i = 1; i < n; i++){ //动态规划状态转移
            for(int j = 0; j <= w;++j){ //不把第i件物品放入
                if(states[i-1][j]){
                    states[i][j] = states[i-1][j];
                }
            }
            for(int j = 0;j < w - weight[i];j++){//把第i件物品放入
                if(states[i-1][j]){
                    states[i][j+weight[i]] = true;
                }
            }
        }
        for(int i = w; i >= 0; i--){
            if(states[n-1][i]){
                return i;
            }
        }
        return 0;
    }

    /**
     * 动态规划
     * @param weight
     * @param n
     * @param w
     * @return
     */
    public int knapsack1(int[] weight,int n,int w){
        boolean[] states = new boolean[w+1]; //默认为false
        states[0] = true; //第一行数据特殊处理
        if(weight[0] <= w){
            states[weight[0]] = true;
        }
        for(int i = 1; i < n; i++){ //动态规划状态转移
            for(int j = w - weight[i]; j >= 0;--j) { //把第i件物品放入
                if (states[j]) {
                    states[j + weight[i]] = true;
                }
            }
        }
        for(int i = w; i >= 0; i--){
            if(states[i]){
                return i;
            }
        }
        return 0;
    }

}

class Packet0_1_Value{
    private int maxV = Integer.MIN_VALUE;
    private int[] items = {2,2,4,6,3};
    private int[] value = {3,4,8,9,6};
    private int n = 5;
    private int w = 9;

    /**
     * 回溯算法
     * @param i
     * @param cw
     * @param cv
     */
    public void f(int i,int cw,int cv){
        if(cw == w || i == n){
            if(cv > maxV){
                maxV = cv;
            }
        }
        f(i+1,cw,cv);
        if(cw + items[i] <= w){
            f(i + 1,cw + items[i],cv + value[i]);
        }
    }

    /**
     *
     * @param weight
     * @param value
     * @param n
     * @param w
     * @return
     */
    public static int knapsack3(int[] weight,int[] value,int n,int w){
        int[][] states = new int[n][w+1];
        //初始化
        for(int i = 0; i < n; i++){
            for(int j = 0; j < w + 1;j++){
                states[i][j] = -1; //此时记录的状态图应该是价格值，并且相同的情况取最大价格
            }
        }
        states[0][0] = 0;
        if(weight[0] <= w){
            states[0][weight[0]] = value[0];
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= w; j++){
                if(states[i-1][j] >= 0){
                    states[i][j] = states[i-1][j];//不放入i物品
                }
            }
            for(int j = 0; j < w-weight[i]; j++){
                if(states[i-1][j] >= 0){
                    int v = states[i-1][j] + value[i];
                    if(v > states[i][j+weight[i]]){
                        states[i][j+weight[i]] = v;
                    }
                }
            }
        }
        //找出最大值
        int maxvalue = -1;
        for (int j = 0; j <= w; ++j){
            if (states[n-1][j] > maxvalue)
                maxvalue = states[n-1][j];
        }
        return maxvalue;
    }

    /**
     * 双十一凑单
     * @param items
     * @param n
     * @param w
     */
    public static void double11advance(int[] items,int n,int w){
        boolean[][] states = new boolean[n][3*w+1];
        states[0][0] = true;
        if(items[0] <= 3*w){
            states[0][items[0]] = true;
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= 3*w;j++){
                if(states[i-1][j]) {
                    states[i][j] = states[i-1][j];
                }
            }
            for(int j = 0; j < 3*w-items[i]; j++){
                if(states[i-1][j]){
                    states[i][j+items[i]] = true;
                }
            }
        }

        int j;
        for(j = w; j < 3*w+1;j++){ //从w开始，输出结果大于w的最小值
            if(states[n-1][j]){
                break;
            }
        }
        if(j == 3*w+1) return;//没有可行解
        for(int i = n-1;i >= 1;--i){
            if(j-items[i] >= 0 && states[i-1][j-items[i]]){
                System.out.println(items[i] + " ");
                j = j-items[i];
            }
        }
        if(j != 0){
            System.out.println(items[0]);
        }
    }
}

