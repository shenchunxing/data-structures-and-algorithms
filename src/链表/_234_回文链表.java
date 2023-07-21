package 链表;

import common.ListNode;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * 难度：简单
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */
/*2023-7-11*/
public class _234_回文链表 {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);

		System.out.println(isPalindrome(head));
	}

	static public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) return true;//1个节点或者没有节点
		if (head.next.next == null) return head.val == head.next.val; //两个节点

		//快慢指针找到中间节点
		ListNode mid = middleNode(head);
		//反转右半部分，得到一个新链表
		ListNode rHead = reverse(mid.next);
		//保留右链表是为了，后续要反转回来，不改变原来的链表结构
		ListNode oldRhead = rHead;
		ListNode lHead = head;

		//一个个比较,如果链表长度是偶数，左右链表长度相等。如果是奇数，右侧链表少一个节点.因此遍历右侧链表比较好。
		while (rHead != null)  {
			if (rHead.val != lHead.val) {
				return false;
			}
			lHead = lHead.next;
			rHead = rHead.next;
		}
		//还原右链表
		reverse(oldRhead);
		return true;
	}

	//中间节点
	static private ListNode middleNode(ListNode head) {
		ListNode fast  = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	//反转
	static ListNode reverse(ListNode head) {
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
