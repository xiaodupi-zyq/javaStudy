package LeetCode;

import java.util.HashMap;

public class FindNumsOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < array.length; i++){
            if(map.get(array[i]) == null){
                map.put(array[i],1);
            }else{
                map.put(array[i],map.get(array[i])+1);
            }
        }
        int[] num = new int[2];
        int k = 0;
        for(int i = 0; i < array.length; i++){
            if(map.get(array[i]) == 1){
                num[k] = array[i];
                k++;
            }
        }
        num1[0] = num[0];
        num2[0] = num[1];
    }
    public static void main(String[] args){
        FindNumsOnce findNumsOnce = new FindNumsOnce();
        int[] array = {3,4,2,6,5,5,2,3};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        findNumsOnce.FindNumsAppearOnce(array,num1,num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
        String str = "afdfd";
        System.out.println(str.indexOf(1));
    }
}
