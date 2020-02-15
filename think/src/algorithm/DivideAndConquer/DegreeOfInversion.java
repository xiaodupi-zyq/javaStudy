package algorithm.DivideAndConquer;

/**
 * @Author: zyq-xiaoliuzi
 * @Description: 计算逆序度
 * @Date: Created in 19:04 2020/2/14
 * @Modified By:
 */
public class DegreeOfInversion {
    private int num = 0;

    /**
     * 逆序度计数
     * @param a
     * @param n
     * @return
     */
    public int count(int[] a,int n){
        num = 0;
        mergeSortCounting(a,0,n-1);
        return num;
    }

    /**
     * 归并排序，分而治之
     * @param a
     * @param p
     * @param r
     */
    private void mergeSortCounting(int[] a,int p,int r){
        if(p >= r){
            return ;
        }
        int q = (p + r) / 2;
        mergeSortCounting(a,p,q);
        mergeSortCounting(a,q+1,r);
        merge(a,p,q,r);
    }

    /**
     * 合并过程，加逆序度计数
     * @param a
     * @param p
     * @param q
     * @param r
     */
    private void merge(int[] a,int p,int q,int r){
        int i = p,j = q + 1,k = 0;
        int[] tmp = new int[r-q+1];
        while(i <= q && j <= r){
            if(a[i] <= a[j]){
                tmp[k++] = a[i++];
            }else{
                num += (q - i + 1);
                tmp[k++] = a[j++];
            }
        }
        while(i <= q){
            tmp[k++] = a[i++];
        }
        while(j <= r){
            tmp[k++] = a[j++];
        }
        for(i = 0; i <= r - p;i++){
            a[p+i] = tmp[i];
        }
    }

}
