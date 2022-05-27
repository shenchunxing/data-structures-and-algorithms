import java.util.Iterator;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 
 * @author MJ
 *
 */
public class _203_移除链表元素 {
	//构建一条全新的链表
	public ListNode removeElements1(ListNode head, int val) {
		if (head == null) return null;
		
		// 新链表的头结点
		ListNode newHead = null;
		// 新链表的尾结点
		ListNode newTail = null;
		
		while (head != null) {
			if (head.val != val) {
				// 将head拼接到newTail的后面
				if (newTail == null) {
					newHead = head;
					newTail = head;
				} else {
					newTail.next = head;
					newTail = head;
				}
			}
			head = head.next;
		}
		if (newTail == null) {
			return null;
		} else {
			// 尾结点的next要清空
			newTail.next = null;
		}
		return newHead;
	}
	
	/**
	 * 虚拟头节点，简化null判断
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode removeElements2(ListNode head, int val) {
		if (head == null) return null;
		ListNode newHead = new ListNode(0); //头节点保持不动
		ListNode newTail = newHead; //尾节点，一开始和头节点位置相同
		while (head != null) {
			if (head.val != val) {
				newTail.next = head; //将链表连起来
				newTail = head;//重新设置尾节点
			}
			head = head.next;
		}
		newTail.next = null;//最后尾节点指向null
		return newHead.next;
	}
	
	
	private ListNode ListNode(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public ListNode removeElements3(ListNode head, int val) {
		if (head == null) return null;
		//设置一个哨兵:为了head不被销毁
		ListNode sentineListNode = new ListNode(0);
		sentineListNode.next = head;
		
		ListNode prevListNode = sentineListNode; //记录上一个节点，默认是哨兵节点
		ListNode curListNode = head;
		
		while (curListNode != null) {
		   if (curListNode.val == val) {
			   //删掉了该节点
			  prevListNode.next = curListNode.next; 
		   } else {
			   prevListNode = curListNode;
		   }
		   curListNode = curListNode.next;
		}
		
		return sentineListNode.next;
	}
	
	
}
