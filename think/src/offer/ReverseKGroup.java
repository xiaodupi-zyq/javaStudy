package offer;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 21:36 2020/7/17
 * @Modified By:
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dump = new ListNode(0);
        dump.next = head;

        ListNode pre = dump;
        ListNode end = dump;

        while(end.next != null){
            for(int i = 0; i < k && end.next != null; i++){
                end = end.next;
            }
            if(end == null){
                break;
            }
            ListNode next = end.next;
            ListNode start = pre.next;
            end.next = null;
            pre.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dump.next;
    }

    public ListNode reverse(ListNode start){
        ListNode p = start;
        ListNode head = null;
        while(p != null){
            ListNode tmp = p;
            p = p.next;
            tmp.next = head;
            head = tmp;
        }
        return head;

    }
}
