package offer;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 22:57 2020/6/24
 * @Modified By:
 */
public class InversePairsSolution {
    private int count = 0;
    public int InversePairs(int [] array) {
        if(array.length <= 1){
            return 0;
        }
        mergeSort(array,0,array.length - 1);
        return count;
    }
    public void mergeSort(int[] array,int start,int end){
        if(start >= end){
            return;
        }
        int mid = (end + start) / 2;
        mergeSort(array,start,mid);
        mergeSort(array,mid + 1,end);
        merge(array,start,mid,end);
    }

    public void merge(int[] array,int start,int mid,int end){
        int[] tmp = new int[end - start + 1];
        int p = start;
        int q = mid + 1;
        int k = 0;
        while(p <= mid && q <= end){
            if(array[p] <= array[q]){
                tmp[k++] = array[p++];
            }else{
                tmp[k++] = array[q++];
                count = (count + (mid - p + 1)) % 1000000007;
            }
        }
        while(p <= mid)
            tmp[k++] = array[p++];
        while(q <= end)
            tmp[k++] = array[q++];
        for(int i=0; i<k; i++){
            array[start + i] = tmp[i];
        }
    }
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,0};
        InversePairsSolution inversePairsSolution = new InversePairsSolution();
        inversePairsSolution.InversePairs(array);

    }
}
