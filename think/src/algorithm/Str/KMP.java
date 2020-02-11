package algorithm.Str;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 14:50 2020/2/11
 * @Modified By:
 */
public class KMP {
    /**
     * KMP算法
     * @param a 主串
     * @param n 主串长度
     * @param b 模式串
     * @param m 模式串长度
     * @return
     */
    public static int kmp(char[] a,int n,char[] b,int m){
        int[] next = getNexts(b,m);
        int j = 0;
        for(int i = 0; i < n;i++){
            while(j > 0 && a[i] != b[i]){
                j = next[j - 1] + 1;//出现坏字符，则前面的字符串是好前缀，取这个好前缀的next值，加一就该是接下来要比较的字符了
            }
            //如果相等说明匹配，j+1继续下次比较
            if(a[i] == b[j]){
                ++j;
            }
            //j == m匹配完成
            if(j == m){
                return i - m + 1;
            }
        }
        return -1;
    }

    /**
     * 寻找next数组
     * @param b
     * @param m
     * @return
     */
    private static int[] getNexts(char[] b, int m){
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        for(int i = 1; i < m; ++i){
            //如果b[i] != b[k+1] 就要找0到i-1的次长可匹配子串，因为b[0,i-1]跟前面的匹配前缀子串是相同的，
            // 所以直接求前面前缀子串的最长可匹配子串就可以了
            while(k != -1 && b[k + 1] != b[i]){
                k = next[k];
            }
            //如果b[i] == b[k+1]所以就直接是最长
            if(b[k+1] == b[i]){
                ++k;
            }
            next[i] = k;
        }
        return next;
    }
}
