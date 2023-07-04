package 链表;

import common.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @author shenchunxing
 *
 */
/*2023-7-4*/
public class _21_合并两个有序链表 {
	public static void main(String[] args) {
		// 创建测试链表1: 1 -> 2 -> 4
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);

		// 创建测试链表2: 1 -> 3 -> 4
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);

		ListNode result = mergeTwoLists(l1, l2);

		// 打印合并后的链表结果
		ListNode node = result;
		while (node != null) {
			System.out.print(node.val + " -> ");
			node = node.next;
		}
		System.out.println("null");
	}

	/*迭代*/
	static public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		/*虚拟头结点，连接两个链表*/
		ListNode newHead = new ListNode(-1);
		/*指针*/
		ListNode pre = newHead;
		/*每次拿出从两个链表中拿出一个节点，接到指针后面，然后被选中的链表走一步*/
		while (l1 != null && l2 != null) {
			if (l1.val >= l2.val) {
				pre.next = l2;
				l2 = l2.next;
			} else  {
				pre.next = l1;
				l1 = l1.next;
			}
			pre = pre.next; //更新指针位置
		}
		pre.next = l1 == null ? l2 : l1;//最后剩下的一个节点，拼接到尾部
		return newHead.next;
    }

	/*递归*/
	static public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else if (l1.val < l2.val) { //l1作为链表头，然后让l1的下一个节点和l2合并成一个新链表
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
}
