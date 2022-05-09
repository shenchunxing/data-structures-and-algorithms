/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class _206_反转链表 {

	//迭代
    public ListNode reverseList(ListNode head) {
    	ListNode prev = null;//指向尾节点
    	ListNode cur = head;//指向头节点
    	while (cur != null) {
    		ListNode next = cur.next;
    		cur.next = prev;
    		prev = cur;
    		cur = next;
    	}
    	return prev;
    }
    
    //递归
    public ListNode reverseList2(ListNode head) {
    	if (head == null || head.next == null) return head;
    	//假设head.next已经反转完成，则head.next.next = head;，然后head.next应该指向null。
    	ListNode newHead = reverseList2(head.next);
    	head.next.next = head;
    	head.next = null;
    	return newHead;
    }
}
	