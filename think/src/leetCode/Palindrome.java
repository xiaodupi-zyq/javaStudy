package LeetCode;

/**
 * @Author: zyq-xiaoliuzi
 * @Description: 回文子串
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

/**
 * O(n)时间复杂度，O(1)空间复杂度
 */
public class Palindrome {
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
}