package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 13:45 2020/7/26
 * @Modified By:
 */
public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result,"",0,0,n);
        return result;
    }
    public static void generate(List<String> ret, String s,int countleft,int countright,int n){
        if(countleft == n && countright == n){
            ret.add(s);
            return;
        }
        if(countright <= countleft){
            if(countleft < n){
                generate(ret,s + "(",countleft + 1, countright,n);
            }
            if(countright < n){
                generate(ret, s + ")",countleft,countright+1,n);
            }
        }
    }
    public static void main(String[] args){
        for(String s : generateParenthesis(4)){
            System.out.println(s);
        }
    }
}
