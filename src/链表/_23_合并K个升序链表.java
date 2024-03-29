package 链表;

import common.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * 难度：困难
 * @author shenchunxing
 *
 */

/*2023-7-4*/
/*在合并2个有序链表的基础上，两两合并*/
public class _23_合并K个升序链表 {
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode ans = null;
		//两两合并
		for (int i = 0; i < lists.length; i++) {
			ans = mergeTwoLists(ans , lists[i]);
		}
		return ans;
    }

	//合并两个有序链表
	private ListNode mergeTwoLists(ListNode a , ListNode b) {
		ListNode preHead = new ListNode(-1);
		ListNode prev = preHead;
		while (a != null && b != null) {
			if (a.val <= b.val) {
				prev.next = a; //a拼接到新链表上
				a = a.next;
			} else {
				prev.next = b; 
				b = b.next;
			}
			prev = prev.next;
		}
		//a或者b链表为为空了
		prev.next = a == null ? b : a ;
		return preHead.next;
	}
}
