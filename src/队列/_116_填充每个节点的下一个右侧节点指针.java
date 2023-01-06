package 队列;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class _116_填充每个节点的下一个右侧节点指针 {
    //层序遍历 O(n) O(n)
    public Node connect2(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) { //被削掉的元素的next指向栈顶元素
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    //O(n) O(1)

    /**
     *    1
     *  2   3
     * 4 5 6 7
     */
    public Node connect(Node root) {
        if (root == null) return root;
        // 从根节点开始
        Node leftmost = root;//lestmost代表当前一层的最左节点
        while (leftmost.left != null) {//还没遍历到叶子节点
            // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
            Node head = leftmost;
            while (head != null) {
                head.left.next = head.right;//两个子节点有一个共同的父节点
                if (head.next != null) {
                    head.right.next = head.next.left;//两个子节点不是同一个父节点
                }
                // 指针向后移动
                head = head.next;
            }
            // 去下一层的最左的节点
            leftmost = leftmost.left;
        }
        return root;
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
