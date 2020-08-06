package LeetCode;

import java.util.Arrays;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 11:38 2020/7/23
 * @Modified By:
 */
public class LeastInterval {

    public int leastInterval(char[] tasks, int n) {
        //任务小于1和任务冷冻期小于1即不冷冻直接返回任务总数
        if(tasks.length <= 1 || n < 1){
            return tasks.length;
        }
        int[] count = new int[26];
        //计算每种任务大小并排序
        for(int i = 0; i < tasks.length; i++){
            count[tasks[i] - 'A'] ++;
        }
        Arrays.sort(count);
        //基本时间肯定是最多任务数的任务，乘以间隔（间隔加一,A->.->.->A）,最后加一
        int retCount = (count[25] - 1) * (n + 1) + 1;
        //判断下面的的任务是不是跟最多任务数相等，如果相等就在retcount+1
        int i = 24;
        for(; i >= 0; i--){
            if(count[i] == count[25]){
                retCount++;
            }else{
                break;
            }
        }
        //如果插空完毕之后还有其他任务，则肯定存在一种方法不会冲突，其最小时间为任务数量
        return Math.max(retCount,tasks.length);
    }
}
