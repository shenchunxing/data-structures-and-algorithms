package 链表;

import java.util.HashSet;
import java.util.Set;

import common.ListNode;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 
 * @author MJ
 *
 */
public class _160_相交链表 {
	public static void main(String[] args) {
		ListNode headA = new ListNode(1);
		headA.next = new ListNode(2);
		headA.next.next = new ListNode(3);

		ListNode headB = new ListNode(4);
		headB.next = new ListNode(5);
		headB.next.next = new ListNode(6);

		System.out.println(getIntersectionNode(headA,headB));
	}
	//两个指针都走一遍链表（两个链表拼起来）
	static public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;
		ListNode curA = headA, curB = headB;
		/*注意：如果两条链表的长度相等，而且不相交，则遍历完本身就变成了curA = curB = null了，循环退出了。
		 *只有链表长度不相同才会继续遍历对方链表。最终遍历的长度是一样的。如果不相交，也会变成curA = curB = null。
		 * */
		while (curA != curB) {
			//curA已经走完?，拼接到headB,否则走一步
			curA = (curA == null) ? headB : curA.next;
			//curB已经走完，拼接到headA,
			curB = (curB == null) ? headA : curB.next;
		}
		//如果一直不相交，最后curA = curB = null
		return curA;
	}

	//哈希集合O(n) O(n):先指向headA,记录headA每一个节点，再指向headB,比较每一个节点是否已经存在
	static public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		Set<ListNode> set = new HashSet<>();
		ListNode temp = headA;
		while (temp != null) {
			set.add(temp);
			temp = temp.next;
		}
		temp = headB;
		while (temp != null) {
			if (set.contains(temp)) {
				return temp;
			}
			temp = temp.next;
		}
		return null;
	}
}
