

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @author shenchunxing
 *
 */
public class _21_合并两个有序链表 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode prehead = new ListNode(-1);
		ListNode prev = prehead;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				prev.next = l1; //prev <- l1
				l1 = l1.next;
			} else {
				prev.next = l2;
				l2 = l2.next;
			}
			prev = prev.next;
		}
		//合并后可能还有1个没有合并完成，直接拼接到后面
		prev.next = l1 == null ? l2 : l1;
		return prehead.next;
    }

}
