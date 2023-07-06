package common;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) { val = x; }
	 @Override
	public String toString() {
		return val + " -> " + next;
	}

	/*打印链表*/
	public void printLinkedList() {
		ListNode current = this;
		while (current != null) {
			System.out.print(current.val + " -> ");
			current = current.next;
		}
		System.out.println("null");
	}
}
