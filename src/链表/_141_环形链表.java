package 链表;

import common.ListNode;

/**
 * https://leetcode.cn/problems/linked-list-cycle/
 */
public class _141_环形链表 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) return true; //有环的话肯定会在某一处相遇
        }
        return false;
    }
}
