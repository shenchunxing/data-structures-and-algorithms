
/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @author shenchunxing
 *
 */

public class _24_两两交换链表中的节点_中等_递归 {
	/**
	 * //递归：递归的终止条件是链表中没有节点，或者链表中只有一个节点，此时无法进行交换。
	 * @param head
	 * @return
	 */
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) { //递归的终止条件是链表中没有节点，或者链表中只有一个节点，此时无法进行交换。
			return head;
		}
		ListNode newhead = head.next; //newhead是链表的第二个节点，也是新链表的头节点，head是原链表的头节点，也是新链表的第二个节点
		head.next = swapPairs(newhead.next); //表示将newHead以后的所有节点两两翻转
		newhead.next = head;//新原节点交换位置
		return newhead;//返回新节点
    }
	
	//迭代
	public ListNode swapPairs2(ListNode head) {
		ListNode dummyHead = new ListNode(0);//虚拟头节点
		dummyHead.next = head;
		ListNode temp = dummyHead;//临时节点，每次跳2个节点
		if (temp.next !=null && temp.next.next != null) {
			ListNode node1 = temp.next;
			ListNode node2 = temp.next.next;
			//交换node1和node2的前后位置
			temp.next = node2;
			node1.next = node2.next;
			node2.next = node1;
			temp = node1;//从交换后的node1开始
		}
		return dummyHead.next;//返回虚拟头节点的下一个节点
	}
}
