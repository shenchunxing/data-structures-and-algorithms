import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 
 * @author MJ
 *
 */
public class _160_相交链表_简单_指针或哈希表 {
	//两个指针都走一遍链表（两个链表拼起来）
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;
		ListNode curA = headA, curB = headB;
		while (curA != curB) { //如果节点相同，说明相交了，直接返回相交节点
			//curA已经走完，拼接到headB
			curA = (curA == null) ? headB : curA.next;
			//curB已经走完，拼接到headA,
			curB = (curB == null) ? headA : curB.next;
		}
		//如果一直不相交，最后curA = curB = null
		return curA;
	}

	//哈希集合O(n) O(n):先指向headA,记录headA每一个节点，再指向headB,比较每一个节点是否已经存在
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
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
