package 链表;

import common.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 难度：简单
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
 */
/*2023-7-11*/
public class _203_移除链表元素 {
	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(2);
		root.next.next.next = new ListNode(3);
		root.next.next.next.next = new ListNode(4);

		System.out.println(removeElements2(root,2));
	}
	//虚拟头节点
	static public ListNode removeElements2(ListNode head, int val) {
		ListNode newHead = new ListNode(-1);
		ListNode newTail  = newHead;//尾指针
		while (head != null) {
			if (head.val != val) {
				newTail.next = head; //让尾指针将节点串起来
				newTail = head;//重新设置尾指针
			}
			head = head.next;
		}
		newTail.next = null; //最后尾指针设置空
		return newHead.next;
	}

	//构建一条全新的链表
	public ListNode removeElements1(ListNode head, int val) {
		if (head == null) return null;
		
		// 新链表的头结点
		ListNode newHead = null;
		// 新链表的尾结点
		ListNode newTail = null;
		
		while (head != null) {
			if (head.val != val) {
				// 将head拼接到newTail的后面
				if (newTail == null) {
					newHead = head;
					newTail = head;
				} else {
					newTail.next = head;
					newTail = head;
				}
			}
			head = head.next;
		}
		if (newTail == null) {
			return null;
		} else {
			// 尾结点的next要清空
			newTail.next = null;
		}
		return newHead;
	}

	private ListNode ListNode(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public ListNode removeElements3(ListNode head, int val) {
		if (head == null) return null;
		//设置一个哨兵:为了head不被销毁
		ListNode sentineListNode = new ListNode(0);
		sentineListNode.next = head;
		
		ListNode prevListNode = sentineListNode; //记录上一个节点，默认是哨兵节点
		ListNode curListNode = head;
		
		while (curListNode != null) {
		   if (curListNode.val == val) {
			   //删掉了该节点
			  prevListNode.next = curListNode.next; 
		   } else {
			   prevListNode = curListNode;
		   }
		   curListNode = curListNode.next;
		}
		
		return sentineListNode.next;
	}
	
	
}
