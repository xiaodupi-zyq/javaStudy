package offer;

/**
 * @Author: zyq-xiaoliuzi
 * @Description: 约瑟夫环
 * @Date: Created in 20:59 2020/6/28
 * @Modified By:
 */
public class LastRemainingMan {
    public int LastRemaining(int n,int m){
        if(n == 0){
            return -1;
        }
        int pos = 0;//最终活下来的那个人位置在最后的数组中肯定是0，此时活下来一个人
        //i从2开始是因为最后一轮是有两个人在竞争谁活下来的资格
        for(int i= 2; i<=n; i++){
            //在上一轮中是怎样的情况，序号为几的人死去让现在的人活下来的呢
            pos = (pos + m) % i; //这次活下来的人加上m % 这次的人就是上次活下来的那个人的序号
        }
        return pos;
    }
}
