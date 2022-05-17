/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class _206_反转链表 {

	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(5);
		head.next.next.next = new ListNode(4);

		System.out.println(reverseList(head));
	}

	//迭代：双指针
   static public ListNode reverseList(ListNode head) {
    	ListNode prev = null;//前一个指针
    	ListNode cur = head;//当前指针
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
	