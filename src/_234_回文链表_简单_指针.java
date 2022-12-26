/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * 
 * @author MJ
 *
 */
public class _234_回文链表_简单_指针 {
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) return true;//1个节点或者没有节点
		if (head.next.next == null) return head.val == head.next.val; //两个节点

		//快慢指针找到中间节点
		ListNode mid = middleNode(head);
		//反转右半部分，得到一个新链表
		ListNode rHead = reverse(mid.next);
		//保留右链表是为了，后续要反转回来，不改变原来的链表结构
		ListNode oldRhead = rHead;

		ListNode lHead = head;

		//一个个比较
		while (rHead != null)  {
			if (rHead.val != lHead.val) return false;
			lHead = lHead.next;
			rHead = rHead.next;
		}
		//还原
		reverse(oldRhead);
		return true;
	}

	//中间节点
	private ListNode middleNode(ListNode head) {
		ListNode fast  = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	//反转
	ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		return prev;
	}
}
