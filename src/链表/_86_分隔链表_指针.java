package 链表;

import com.mj.Main;

import common.ListNode;

/**
 * https://leetcode-cn.com/problems/partition-list/
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置
 */
/*2023-7-6*/
public class _86_分隔链表_指针 {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(2);

		ListNode result = partition(head,3);
		result.printLinkedList();
	}

	/*思路就是创建2个链表，将小于x的串在一起，将大于等于x的串在一起。最后拼接在一起*/
	static public ListNode partition(ListNode head, int x) {
		if (head == null) return head;
		ListNode lHead = new ListNode(0); //左链表的头尾节点
		ListNode lTail = lHead;
		ListNode rHead = new ListNode(0);//右链表的头尾节点
		ListNode rTail = rHead;
		while (head != null) {
			if (head.val < x) {
				lTail.next = head;
				lTail = head;
			} else {
				rTail.next = head;
				rTail = head;
			}
			head = head.next;
		}
		/*先让右链表的尾巴null，拼接左链表的尾巴到右链表的头*/
		rTail.next = null;
		lTail.next = rHead.next;
		return lHead.next;
	}
}
