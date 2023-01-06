package 链表;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 * 
 * @author shenchunxing
 *
 */
//题意：输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
      //输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
	//链表是7 - 13 - 11 - 10 - 1
	//random指针是指向的链表的位置
public class _138_复制带随机指针的链表 {

	HashMap<Node, Node> cachedNodeMap = new HashMap<>();

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

	//当前节点完成创建后，去创建next和random节点，返回节点，这样就完成了一次链表的拷贝操作。
	public Node copyRandomList(Node head) {
		if (head == null) return null;
		if (cachedNodeMap.containsKey(head)) return cachedNodeMap.get(head); //节点已经存在，防止重复拷贝
		Node node = new Node(head.val); //拷贝根节点
		cachedNodeMap.put(head, node);//缓存
		node.next = copyRandomList(head.next); //拷贝next节点
		node.random = copyRandomList(head.random); //拷贝random节点
		return node;
	}


	public Node copyRandomList2(Node head) {
		if (head == null) {
			return null;
		}
		//第一次遍历：每次的幅度为next.next,原本的链表A - B - C
		//假设原本A的random指向的是C
		//变成了A - A' - B - B' - C - C'
		for (Node node = head; node != null; node = node.next.next) {
			Node nodeNew = new Node(node.val);
			nodeNew.next = node.next;
			node.next = nodeNew;
		}
		//第二次遍历：每次的幅度为next.next,原本的链表A - A' - B - B' - C - C'
		//A'的random节点就是A的random节点指向的节点的后继节点C'
		for (Node node = head; node != null; node = node.next.next) {
			Node nodeNew = node.next; //这里的是A' B' C'
			nodeNew.random = (node.random != null) ? node.random.next : null;
		}
		Node headNew = head.next; //引用下拷贝链表的头节点，不引用会导致链表释放
		//分离原链表和拷贝链表
		for (Node node = head; node != null; node = node.next) {
			Node nodeNew = node.next;
			node.next = node.next.next; //分离原链表
			nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null; //分离拷贝链表
		}
		return headNew;
	}
}
