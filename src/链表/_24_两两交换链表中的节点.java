package 链表;

import common.ListNode;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @author shenchunxing
 *
 */

/*2023-7-4*/
public class _24_两两交换链表中的节点 {
	public static void main(String[] args) {
		// 创建测试链表: 1 -> 2 -> 3 -> 4
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);

		ListNode result = swapPairs(head);

		// 打印交换后的链表结果
		ListNode node = result;
		while (node != null) {
			System.out.print(node.val + " -> ");
			node = node.next;
		}
		System.out.println("null");
	}
	/**
	 * 递归：递归的终止条件是链表中没有节点，或者链表中只有一个节点，此时无法进行交换。
	 */
	static public ListNode swapPairs(ListNode head) {
		/*递归出口：两个交换节点和待交换节点有一个为空，就退出*/
		if (head == null || head.next == null) {
			return head;
		}
		/*新的根节点newHead*/
		ListNode newhead = head.next;
		/*将newHead以后的所有节点两两翻转*/
		head.next = swapPairs(newhead.next);
		/*将旧根节点拼接到新根节点后面*/
		newhead.next = head;
		/*返回新根节点*/
		return newhead;
    }
}
