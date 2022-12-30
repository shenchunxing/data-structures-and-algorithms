
/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class _19_删除链表的倒数第N个结点_快慢指针 {
	//利用快慢指针，第一个指针指向n+1的位置，第二个指针从头开始
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode dummy = new ListNode(0);
       dummy.next = head;
       ListNode fast = dummy;
       ListNode slow = dummy;
        for (int i = 0; i <= n; i++) { //快指针先走到第n个节点处
            fast = fast.next;
        }
        while (fast != null) {//快指针走完剩下的链表长度,慢指针所处的位置就是需要删除的节点位置，删除
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
