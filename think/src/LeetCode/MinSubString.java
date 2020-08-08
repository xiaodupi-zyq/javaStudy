package LeetCode;

import java.util.HashMap;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 13:47 2020/8/7
 * @Modified By:
 */
public class MinSubString {
    public String minWindow(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if(len1 < len2){
            return null;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < len2; i++){
            char tmp = t.charAt(i);
            if(map.containsKey(tmp)){
                map.put(tmp,map.get(tmp)+1);
            }else{
                map.put(tmp,1);
            }
        }
        String ret = new String();
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = len2 - 1;
        while(i <= len1 - len2){
            HashMap<Character,Integer> tmp = new HashMap<>(map);
            if(hasSubString(s,i,j,tmp)){
                if(j - i + 1 < min){
                    min = j - i + 1;
                    ret = s.substring(i,j + 1);
                }
                i++;
            }else{
                if(j < len1 - 1){
                    j++;
                }else{
                    break;
                }
            }
        }
        return ret;
    }
    public boolean hasSubString(String s, int start,int end, HashMap<Character,Integer> map){
        for(int i = start; i <= end; i++){
            char tmp = s.charAt(i);
            if(map.containsKey(tmp)){
                map.put(tmp,map.get(tmp) - 1);
            }
        }
        for(Character key : map.keySet()){
            if(map.get(key) > 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String s = "ADOBECODEBANC";
        String t = "ABC";
        MinSubString minSubString = new MinSubString();
        System.out.println(minSubString.minWindow(s,t));
    }
}
