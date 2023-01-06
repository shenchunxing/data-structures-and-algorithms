package 链表;

import common.ListNode;

/**
 * https://leetcode-cn.com/problems/partition-list/
 * 
 * @author MJ
 *
 */
public class _86_分隔链表_指针 {
	public ListNode partition(ListNode head, int x) {
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
		rTail.next = null;//右链表的尾巴要为null
		lTail.next = rHead.next; //拼接在一起
		return lHead.next;
	}
}
