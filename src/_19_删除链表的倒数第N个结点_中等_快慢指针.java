
/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class _19_删除链表的倒数第N个结点_中等_快慢指针 {
	//利用快慢指针，第一个指针指向n+1的位置，第二个指针从头开始
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode dummy = new ListNode(0);
       dummy.next = head;
       ListNode fast = dummy;
       ListNode slow = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
