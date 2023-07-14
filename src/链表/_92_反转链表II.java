package 链表;

import common.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * 难度：中等
 * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
/*2023-7-14*/
public class _92_反转链表II {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		System.out.println(reverseBetween(head,2,4));
	}
	static public ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode dummpNode = new ListNode(-1);
		dummpNode.next = head;
		ListNode prev = dummpNode;
		//让prev到left的前一个节点
		for (int i = 0 ; i < left - 1; i++) {
			prev = prev.next;
		}

		//走到right的节点,直接从prev出发，节省一些走的步数
		ListNode rightNode = prev;
		for (int i = 0 ; i < right - left + 1; i++) {
			rightNode = rightNode.next;
		}

		//切出子链表
		/*先保留子链表的头尾节点，等子链表反转后，需要拼接到原链表上*/
		ListNode leftNode = prev.next;
		ListNode curNode = rightNode.next;
		/*截断和原链表的关联，变成一个独立的链表*/
		prev.next = null;
		rightNode.next = null;

		//反转链表:left ... -> right -> null
		reverse(leftNode);

		//接回到原来的链表
		prev.next = rightNode;
		leftNode.next = curNode;

		return dummpNode.next;
    }

	static private ListNode reverse(ListNode head) {
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
