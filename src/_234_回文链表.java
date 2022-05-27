/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * 
 * @author MJ
 *
 */
public class _234_回文链表 {
	//要求空间复杂度O(1),如果没有要求，可以直接翻转链表，一个个对比
	/**
	 * 利用快慢指针找到中间节点，反转右侧链表后每个节点和左侧节点比较
	 * @param head
	 * @return
	 */
    public boolean isPalindrome(ListNode head) {
    	if (head == null || head.next == null) return true;  //1个节点或者空节点
    	if (head.next.next == null) return head.val == head.next.val; //2个节点
    	
    	//至少3个节点
    	ListNode mid = middleNode(head);// 找到中间节点
    	ListNode rHead = reverseList(mid.next); // 翻转右半部分（中间节点的右边部分）
    	ListNode lHead = head; //左侧头节点
    	ListNode rOldHead = rHead; //恢复右侧头节点，为了不破坏链表
    	
    	// 从lHead、rHead出发，判断是否为回文链表
    	boolean result = true;
    	while (rHead != null) {
    		if (lHead.val != rHead.val) {
    			result = false;
    			break;
    		}
    		rHead = rHead.next;
    		lHead = lHead.next;
    	}
    	
    	// 恢复右半部分（对右半部分再次翻转），不破坏原来的链表结构
    	reverseList(rOldHead);
    	return result;
    }

    /**
     * 找到中间节点（右半部分链表头结点的前一个节点）
     * 比如 1>2>3>2>1中的3是中间节点
     * 比如 1>2>2>1中左边第一个2是中间节点
     * @param head
     * @return
     */
	private ListNode middleNode(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) { //奇数和偶数的情况都适配
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	/**
	 * 翻转链表
	 * @param head 原链表的头结点
	 * 比如原链表：1>2>3>4>null，翻转之后是：4>3>2>1>null
	 * @return 翻转之后链表的头结点（返回4）
	 */
	private ListNode reverseList(ListNode head) {
		ListNode newHead = null;
		while (head != null) {
			ListNode tmp = head.next;
			head.next = newHead;
			newHead = head;
			head = tmp;
		}
		return newHead;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
//		head.next.next.next.next = new ListNode(1);
		System.out.println(head);
		
		_234_回文链表 obj = new _234_回文链表();
		obj.isPalindrome(head);
		
		System.out.println(head);
	}
}
