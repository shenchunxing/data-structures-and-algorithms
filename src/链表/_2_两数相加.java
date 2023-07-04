package 链表;

import common.ListNode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 
 * @author MJ
 *
 */

/*2023-7-4*/
public class _2_两数相加 {
	public static void main(String[] args) {
		// 创建测试链表 l1: 2 -> 4 -> 3
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		// 创建测试链表 l2: 5 -> 6 -> 4
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		// 调用函数计算结果
		ListNode result = addTwoNumbers(l1, l2);

		// 打印计算结果
		ListNode node = result;
		while (node != null) {
			System.out.print(node.val + " -> ");
			node = node.next;
		}
		System.out.println("null");
	}

	static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		ListNode dummNode = new ListNode(0); //设置头节点，防止链表被释放
		ListNode last =  dummNode; //尾节点

		int carry = 0;
		while (l1 != null || l2!= null) {
			int v1 = 0;
			if (l1 != null) {
				v1 = l1.val;
				l1 = l1.next;
			}
			int v2 = 0;
			if (l2 != null) {
				v2 = l2.val;
				l2 = l2.next;
			}
			int sum = v1 + v2 + carry;
			//进位是否存在
			carry = sum / 10;

			//获取当前的值
			last.next = new ListNode(sum % 10);
			//链表串起来
			last = last.next;
		}
		//检查最后的进位是否存在，如果存在需要多1位
		if (carry == 1) {
			last.next = new ListNode(1);
		}
		return dummNode.next;
	}
}
