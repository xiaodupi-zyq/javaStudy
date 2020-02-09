package algorithm.Sort;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 20:44 2020/2/9
 * @Modified By:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class SortList {
    /**
     * 链表归并排序
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        //判断边界条件
        if(head == null || head.next == null){
            return head;
        }
        //取中间节点
        ListNode mid = getMid(head);
        //取中间节点后面的节点
        ListNode midNext = mid.next;
        //将链表从中间断开
        mid.next = null;
        //合并两个链表并将新链表的头结点返回
        return mergeTwoLists(sortList(head), sortList(midNext));
    }

    /**
     * 合并两个链表
     * @param head
     * @return
     */
    public ListNode getMid(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode mergeTwoLists(ListNode p,ListNode q){
        if(p == null){
            return q;
        }
        if(q == null){
            return p;
        }
        ListNode first = p;
        ListNode second = q;
        ListNode head,tmp;
        if(first.val < second.val){
            head = tmp = first;
            first = first.next;
        }else{
            head = tmp = second;
            second = second.next;
        }
        while(first != null && second != null){
            if(first.val < second.val){
                tmp.next = first;
                tmp = tmp.next;
                first = first.next;
            }else{
                tmp.next = second;
                tmp = tmp.next;
                second = second.next;
            }
        }
        if(first != null){
            tmp.next = first;
        }
        if(second != null){
            tmp.next = second;
        }
        return head;
    }

    /**
     * 插入排序，原生插入排序是将数组分为前面的已排序区，和后面的未排序区，从当前元素向前进行遍历，找到插入位置进行插入；
     * 但是在单链表中，向前遍历不方便，所以在链表中插入排序要向后找，直到找到一个位置比当前元素大，将当前元素插入到这个位置上，
     * 从而完成插入排序
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        //判断边界条件
        if(head == null || head.next == null){
            return head;
        }
        //定义一个头结点，使用整数最小值定义
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        //当前节点是链表的头结点，从当前节点往后是未排序区，dummy引导的是已排序的区，
        ListNode curr = head;
        //当前节点引导的链表不为空时继续排序
        while(curr != null){
            //遍历链表，在dummy节点引导的链表中找到相应的位置插入
            ListNode pre = dummy;
            //保持当前节点的下一个节点
            ListNode next = curr.next;
            //寻找位置
            while(pre.next != null && pre.next.val < curr.val){
                pre = pre.next;
            }
            //插入
            curr.next = pre.next;
            pre.next = curr;
            curr = next;
        }
        return dummy.next;
    }
}
