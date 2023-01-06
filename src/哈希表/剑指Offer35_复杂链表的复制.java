package 哈希表;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 * 本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 */
public class 剑指Offer35_复杂链表的复制 {
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

    HashMap<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        //如果已经存在，直接返回节点
        if (this.map.containsKey(head)) {
            return this.map.get(head);
        }
        //否则新建一个节点
        Node node = new Node(head.val);
        this.map.put(head,node);//存入哈希表
        node.next = this.copyRandomList(head.next); //递归下一个节点
        node.random = this.copyRandomList(head.random);//递归random节点
        return node;
    }
}
