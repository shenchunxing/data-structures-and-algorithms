/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class _206_反转链表_简单_迭代递归 {
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
    public ListNode reverseList2(ListNode head) {
    	if (head == null || head.next == null) return head;
		ListNode newHead = reverseList2(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
    }
}
	