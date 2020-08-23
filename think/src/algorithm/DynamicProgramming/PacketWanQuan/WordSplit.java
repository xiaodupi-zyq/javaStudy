package algorithm.DynamicProgramming.PacketWanQuan;

import java.util.HashSet;
import java.util.List;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 16:58 2020/8/9
 * @Modified By:
 */
public class WordSplit {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        //这次外层是dp长度，内层是匹配字符串，是因为字符串不能裁开来用的
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

}
