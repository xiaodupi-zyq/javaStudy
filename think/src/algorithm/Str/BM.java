package algorithm.Str;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 15:00 2020/2/10
 * @Modified By:
 */
public class BM {
    private static final int SIZE = 256;

    /**
     * 生成模式串包含字符的坏字符位置索引散列表
     * @param b
     * @param m
     * @param bc
     */
    private void generateBC(char[] b,int m,int[] bc){
        for(int i = 0; i < SIZE;i++){
            bc[i] = -1;
        }
        for(int i = 0; i < m; i++){
            int ascii = (int)b[i];//计算b[i]的SACII值
            bc[ascii] = i;
        }
    }

    /**
     * 生成suffix，prefix数组
     * @param b 模式串
     * @param m 模式串长度
     * @param suffix 模式串中是否有好后缀，且其长度为k的起始下标存放在suffix[i]中
     * @param prefix 是否存在跟模式串相同的前缀子串
     */
    private void generateGS(char[] b,int m, int[] suffix,boolean[] prefix){
        //初始化
        for(int i = 0; i < m; ++i){
            suffix[i] = -1;
            prefix[i] = false;
        }
        //i从0到m-2求公共子串
        for(int i = 0; i < m - 1;++i){
            int j = i;
            int k = 0;//公共后缀子串的长度
            while(j >= 0 && b[j] == b[m - 1 - k]) {
                --j;
                ++k;
                suffix[k] = j+1; //j+1表示公共后缀子串在b[0,i]的起始下标
            }
            if(j == i) prefix[k] = true;//如果公共后缀子串也是模式串的前缀子串
        }
    }

    /**
     * bm算法
     * @param a 主串
     * @param n 主串长度
     * @param b 模式串
     * @param m 模式串长度
     * @return
     */
    public int bm(char[] a,int n,char[] b,int m){
        int[] bc = new int[SIZE];//记录模式串中每个字符最后出现的位置
        generateBC(b,m,bc);//构建字符哈希表
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(b,m,suffix,prefix);
        int i = 0;//i表示主串和模式串对齐的第一个字符
        while ( i <= n - m){
            int j;
            //模式串从后往前匹配
            for(j = m - 1; j >= 0; --j){
                if(a[i+j] != b[j]) break;//遇见坏字符跳出
            }
            //判断是否是已经匹配完全
            if(j < 0){
                return i;
            }
            int x = j - bc[(int)a[i+j]];
            int y = 0;
            if(j < m -1){
                y = moveByGS(j,m,suffix,prefix);
            }
            i = i + Math.max(x,y);
        }
        return -1;
    }

    /**
     *
     * @param j
     * @param m
     * @param suffix
     * @param prefix
     * @return
     */
    private int moveByGS(int j,int m,int[] suffix,boolean[] prefix){
        int k = m - 1 - j;
        if(suffix[k] != -1) return j - suffix[k] +1;
        for(int r = j + 2; r <= m -1;++r){
            if(prefix[m-r] == true){
                return r;
            }
        }
        return m;
    }

}
