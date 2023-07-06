package 链表;

import common.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
/*2023-7-6*/
public class _206_反转链表 {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ListNode result = reverseList(head);
		result.printLinkedList();
	}
	//迭代：双指针
   static public ListNode reverseList(ListNode head) {
	    ListNode pre = null;
    	ListNode cur = head;
		while (cur != null) {
			ListNode temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		return pre;
    }
    
    //递归
	static public ListNode reverseList2(ListNode head) {
    	if (head == null || head.next == null) return head;
		/*将除头结点外，其他链表反转 5->4->3->2<1*/
		ListNode newHead = reverseList2(head.next);
		/*翻转最后一个节点5->4->3->2->1，此时1也指向2，1->2*/
		head.next.next = head;
		/*去掉1->2*/
		head.next = null;
		return newHead;
    }
}
	