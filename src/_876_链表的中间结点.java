/**
 * https://leetcode.cn/problems/middle-of-the-linked-list/
 */
public class _876_链表的中间结点 {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) { //快指针走完了，慢指针刚好到中间
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
