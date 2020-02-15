package algorithm;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 16:55 2020/2/15
 * @Modified By:
 */
public class Packet0_1 {
    public int maxW = Integer.MIN_VALUE;

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
        int[] a = {23,4,11,6,5,7,21,3,1,2};
        p.f(0,0,a,10,100);
        System.out.println(p.maxW);
    }
}
