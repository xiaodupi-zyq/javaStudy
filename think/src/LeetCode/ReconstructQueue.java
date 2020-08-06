package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 21:46 2020/7/24
 * @Modified By:
 */
public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        //h相同的按照k升序，h不同的按照h降序
        Arrays.sort(people,(int[] o1, int[] o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]));
        LinkedList<int[]> list = new LinkedList<>();
        for(int[] p : people){
            //LinkedList插入在索引处插入，后面的依次往后
            list.add(p[1],p);
        }
        int n = people.length;
        return list.toArray(new int[n][2]);
    }
}
