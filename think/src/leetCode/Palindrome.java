package LeetCode;

/**
 * @Author: zyq-xiaoliuzi
 * @Description: 回文子串总结
 * @Date: Created in 23:12 2020/3/13
 * @Modified By:
 */

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}

public class Palindrome {
    /**
     *O(n)时间复杂度，O(1)空间复杂度，
     *链表回文子串问题，使用双指针，可以将链表分为前面一半，后面一半，在慢指针中，再将前面一半进行翻转，然后进行比较
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode p = head;
        ListNode q = null;
        while(fast != null && fast.next != null){
            p = slow;
            slow = slow.next;
            fast = fast.next.next;
            p.next = q;
            q = p;
        }
        if(fast == null){
            p = slow;
        }else{
            p = slow.next;
        }
        while(p != null && q != null){
            if(p.val != q.val){
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }

    /**
     * 找出字符串中所有回文子串的个数
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int sum = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length();i++){
            for(int j = i; j >= 0;j--){
                //向前比较字符串，如果出现字符和目前字符一样，判断是否是前面一个字符，两个字符中间的字符串也是回文子串
                if(s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[i-1][j+1])){
                    dp[i][j] = true;
                    sum++;
                }
            }
        }
        return sum;
    }
    public static void main(String[] args){
        Palindrome palindrome = new Palindrome();
        String s = "abcacb";
        int sum = palindrome.countSubstrings(s);
        System.out.println(sum);
    }


}

class Solution1 {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int min = nums[len-1];
        int l = 0, r = -1;
        for(int i=0;i<len;i++){
            //如果后面出现了比max还小的数，说明到这个数都是需要重排的，否则记录新的max
            if(max>nums[i]){
                r = i;
            }else{
                max = nums[i];
            }
            //如果前面出现了比min还大的数，说明从这个数开始往后是需要重排的，否则记录新min
            //如果都不需要重排r和l都不会变化，最后还是个0
            if(min<nums[len-i-1]){
                l = len-i-1;
            }else{
                min = nums[len-i-1];
            }
        }
        return r-l+1;
    }

    public static void main(String[] args){
        Solution1 solution1 = new Solution1();
        int[] nums = {28,54,7,-70,22,65,-6};
        int n = solution1.findUnsortedSubarray(nums);
    }
}