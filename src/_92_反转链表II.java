/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * @author shenchunxing
 *
 */
public class _92_反转链表II {
	public ListNode reverseBetween(ListNode head, int left, int right) {

		ListNode dummpNode = new ListNode(-1);
		dummpNode.next = head;
		ListNode prev = dummpNode;
		
		for (int i = 0 ; i < left - 1; i++) {
			prev = prev.next;
		}
		
		ListNode curr = prev.next;
		ListNode next = null;
		
		for (int i = 0 ;i < right - left;i++) {
			next = curr.next;
			curr.next = next.next;
			next.next = prev.next;
			prev.next = next;
		}
		
		return dummpNode.next;
    }
}
