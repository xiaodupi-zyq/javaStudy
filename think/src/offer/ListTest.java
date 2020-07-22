package offer;

/**
 * @Author: zyq-xiaoliuzi
 * @Description: 链表相关的题
 * @Date: Created in 14:55 2020/7/5
 * @Modified By:
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}


public class ListTest {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        if(pHead.val == pHead.next.val){
            ListNode tmp = pHead.next;
            while(tmp != null && tmp.val == pHead.val){
                tmp = tmp.next;
            }
            return deleteDuplication(tmp);
        }else{
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null || pHead.next == null){
            return null;
        }
        ListNode p = pHead;
        ListNode q = pHead;
        while(p != null && q != null){
            p = p.next;
            q = q.next.next;
            if(p == q){
                q = pHead;
                while(p != q){
                    p = p.next;
                    q = q.next;
                }
                return p;
            }
        }
        return null;
    }
}
