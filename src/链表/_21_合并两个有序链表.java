package 链表;

import common.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @author shenchunxing
 *
 */
public class _21_合并两个有序链表 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode newHead = new ListNode(-1);
		ListNode pre = newHead;
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

	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
}
