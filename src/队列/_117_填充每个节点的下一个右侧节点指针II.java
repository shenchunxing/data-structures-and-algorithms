package 队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class _117_填充每个节点的下一个右侧节点指针II {
    /**
     * 层序遍历 O(n) O(n)
     * @param root
     * @return
     */
    public Node connect1(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node last = null; //记录上一次遍历的节点
            for (int i = 0; i < size; i++) {
                Node node = queue.poll(); //node是当前遍历的节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (i != 0) {
                    last.next = node;//上一个遍历的节点的next是当前遍历节点
                }
                last = node;
            }
        }
        return root;
    }

    /**
     * 优化思路：一旦在某层的节点之间建立了next指针，那这层节点实际上形成了一个链表。因此，如果先去建立某一层的next 指针，再去遍历这一层，就无需再使用队列了
     */
    //O(n) O(1)
    /**
     *   1
     * 2  3
     *4 5
     */
    //不理解
    Node last = null,nextStart = null;
    public Node connect(Node root) {
        if (root == null) return root;
        Node start = root;
        while (start != null) {
             last = null;
             nextStart = null;
             for (Node p = start ; p != null ; p = p.next) {
                 if (p.left != null) {
                     handle(p.left);
                 }
                 if (p.right != null) {
                     handle(p.right);
                 }
             }
             start = nextStart;
        }
        return root;
    }

    private void handle(Node p) {
        if (last != null) {
            last.next = p;
        }
        if (nextStart != null) {
            nextStart = p;
        }
        last = p;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
