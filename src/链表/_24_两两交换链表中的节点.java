package 链表;

import common.ListNode;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @author shenchunxing
 *
 */

public class _24_两两交换链表中的节点 {
	/**
	 * 递归：递归的终止条件是链表中没有节点，或者链表中只有一个节点，此时无法进行交换。
	 */
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newhead = head.next; //newhead是链表的第二个节点，也是新链表的头节点，head是原链表的头节点，也是新链表的第二个节点
		head.next = swapPairs(newhead.next); //表示将newHead以后的所有节点两两翻转
		newhead.next = head;//新原节点交换位置
		return newhead;//返回新节点
    }
}
