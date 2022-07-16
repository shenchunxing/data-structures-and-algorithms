/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * @author shenchunxing
 *
 */
public class _92_反转链表II_中等_截断反转再拼回去 {
	public ListNode reverseBetween(ListNode head, int left, int right) {

		ListNode dummpNode = new ListNode(-1);
		dummpNode.next = head;
		ListNode prev = dummpNode;
		//让prev到left的前一个节点
		for (int i = 0 ; i < left - 1; i++) {
			prev = prev.next;
		}

		//来到right的节点
		ListNode rightNode = prev;
		for (int i = 0 ; i < right - left + 1; i++) {
			rightNode = rightNode.next;
		}

		//切出子链表
		ListNode leftNode = prev.next;
		ListNode curNode = rightNode.next;
		prev.next = null;
		rightNode.next = null;

		//反转链表:left ... -> right -> null
		reverse(leftNode);

		//接回到原来的链表
		prev.next = rightNode;
		leftNode.next = curNode;

		return dummpNode.next;
    }

	private ListNode reverse(ListNode head) {
		ListNode cur = head;
		ListNode prev = null;
		while (cur != null) {
			ListNode temp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
		}
		return prev;
	}
}
