import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 * 
 * @author shenchunxing
 *
 */
public class _138_复制带随机指针的链表 {

	HashMap<Node, Node> map = new HashMap<>();

	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	/**
	 * 哈希表 + 递归
	 * 
	 * @param head
	 * @return
	 */
	public Node copyRandomList(Node head) {
		if (head == null)
			return null;
		if (map.containsKey(head))
			return map.get(head);

		Node node = new Node(head.val);
		map.put(head, node);
		node.next = copyRandomList(head.next);
		node.random = copyRandomList(head.random);
		return node;
	}

	/**
	 * 3次遍历
	 * 
	 * @param head
	 * @return
	 */
	public Node copyRandomList2(Node head) {
		if (head == null) {
			return null;
		}
		for (Node node = head; node != null; node = node.next.next) {
			Node nodeNew = new Node(node.val);
			nodeNew.next = node.next;
			node.next = nodeNew;
		}
		for (Node node = head; node != null; node = node.next.next) {
			Node nodeNew = node.next;
			nodeNew.random = (node.random != null) ? node.random.next : null;
		}
		Node headNew = head.next;
		for (Node node = head; node != null; node = node.next) {
			Node nodeNew = node.next;
			node.next = node.next.next;
			nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
		}
		return headNew;
	}
}
