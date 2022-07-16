/**
 * https://leetcode.cn/problems/linked-list-cycle/
 */
public class _141_环形链表_简单_快慢指针 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) return true; //相遇了，有环
        }
        return false;
    }
}
