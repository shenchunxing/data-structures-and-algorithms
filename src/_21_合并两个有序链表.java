

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
			pre = pre.next; //每次循环，指针移动一次
		}
		pre.next = l1 == null ? l2 : l1;
		return newHead.next;
    }
}
