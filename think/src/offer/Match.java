package offer;

/**
 * @Author: zyq-xiaoliuzi
 * @Description: 字符串匹配/动态规划解法
 * @Date: Created in 10:56 2020/7/5
 * @Modified By:
 */
public class Match {
    public boolean match(String str,String pattern){
        char[] s = str.toCharArray();
        char[] p = str.toCharArray();
        int m = s.length;
        int n = p.length;

        boolean[][] dp = new boolean[m+1][n+1];//字符串为空情况所以加1
        dp[0][0] = true;//空字符串，空匹配为true

        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                //匹配串是否为空
                if(j == 0){
                    //匹配串为空，字符串为空则匹配，否则一定不匹配
                    dp[i][j] = (i == 0);
                }else{//匹配串不为空，要选择看当前字符是否为*
                    if(i > 0 && (s[i - 1] == p[i - 1] || p[i - 1] == '.')){
                        dp[i][j] = dp[i - 1][j - 1];
                    }else{
                        //匹配串此时为*，则要选择看或者不看，|=是重点，要深思
                        if(j >= 2){
                            dp[i][j] |= dp[i][j - 2];
                        }
                        if(i > 1 && j >= 2 && (s[i - 1] == p[j - 2] || p[j - 2] == '.')){
                            dp[i][j] |= dp[i - 1][j];
                        }
                    }
                }
            }
        }
        return dp[m][n];
    }

    public boolean rmatch(char[] str,int li,char[] pattern,int lj){
        if(li == str.length && lj == pattern.length){
            return true;
        }else if(lj == pattern.length){
            return false;
        }
        boolean next = (lj+1 < pattern.length && pattern[lj+1] == '*');
        if(next){
            if(li < str.length && (pattern[lj] == '.' || pattern[lj] == str[li])){
                return rmatch(str,li+1,pattern,lj) || rmatch(str,li,pattern,lj+2);
            }else{
                return rmatch(str,li,pattern,lj+2);
            }
        }else{
            if(li < str.length && (pattern[lj] == '.' || pattern[lj] == str[li])){
                return rmatch(str,li+1,pattern,lj+1);
            }else{
                return false;
            }
        }

    }

}
