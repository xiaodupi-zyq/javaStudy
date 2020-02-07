package algorithm;


import java.util.ArrayList;
import java.util.Comparator;

public class Permutations {
    /**
     * int[] a = a = {1,2,3,4};printPermutations(a,4,4)
     * k表示要处理的子数据的数据个数
     */
    public void printPermutations(ArrayList<String> list, int[] data, int n, int k){
        String str = "";
        if(k == 1) {
            for(int i = 0; i < n; ++i){
                System.out.print(data[i] + " ");
                str += data[i];
            }
            list.add(str);
            System.out.println(str);
            System.out.println();
        }

        for(int i = 0; i < k; ++i){
            int tmp = data[i];
            data[i] = data[k - 1];
            data[k - 1] = tmp;

            printPermutations(list,data,n,k-1);

            tmp = data[i];
            data[i] = data[k - 1];
            data[k - 1] = tmp;
        }
    }
    public static void main(String[] args){
        Permutations p = new Permutations();
        int[] a = {1,2,3};
        ArrayList<String> list = new ArrayList<>();
        p.printPermutations(list,a,3,3);
        System.out.println(list);
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
        String string = "1231";



    }
}
