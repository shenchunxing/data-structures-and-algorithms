package 链表;

import common.ListNode;

/**
 * https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 *
 */
public class _1290_二进制链表转整数 {
	
	public int getDecimalValue(ListNode head) {

/**
 * 5÷2=2余1 
2÷2=1余0 
1÷2=0余1  
 ===> 得出二进制 101 .
反推回去 商 x 除数 + 余数 
=> 0 x 2 + 1 = 1 
-> 1 x 2 + 0 = 2
-> 2 x 2 +1 = 5
 */
		ListNode node = head;
		int ans = 0;
		while (node != null) {
			ans = ans * 2 + node.val;
			node = node.next;
		}
		
		return ans;
    }
}
