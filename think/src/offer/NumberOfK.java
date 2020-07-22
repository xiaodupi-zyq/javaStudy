package offer;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 17:55 2020/6/26
 * @Modified By:
 */
public class NumberOfK {
    public int GetNumberOfK(int[] array,int K){
        int first = binarySearch(array,K);
        int last = binarySearch(array,K+1);
        return (first == array.length || array[first] != K) ? 0 : last - first;
    }
    public int binarySearch(int[] array,int K){
        int l = 0;
        int h = array.length;//注意h的取值，取len还是len-1
        while(l < h){
            int m = l + (h - l) >> 1;
            if(array[m] >= K){
                h = m;
            }else{
                l = m+1;
            }
        }
        return l;
    }
}