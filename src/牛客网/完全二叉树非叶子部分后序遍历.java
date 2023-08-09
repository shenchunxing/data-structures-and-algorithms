package 牛客网;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 给定一个以顺序储存结构存储整数值的完全二叉树序列（最多1000个整数），请找出此完全二叉树的所有非叶子节点部分，然后采用后序遍历方式将此部分树（不包含叶子）输出。
 *
 * 1、只有一个节点的树，此节点认定为根节点（非叶子）。
 *
 * 2、此完全二叉树并非满二叉树，可能存在倒数第二层出现叶子或者无右叶子的情况
 *
 * 其他说明：二叉树的后序遍历是基于根来说的，遍历顺序为：左-右-根
 * 输入描述:
 *
 * 一个通过空格分割的整数序列字符串
 * 输出描述:
 *
 * 非叶子部分树结构
 * 示例1  输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 1 2 3 4 5 6 7
 *
 * 输出
 *
 * 2 3 1
 *
 * 说明
 *
 * 找到非叶子部分树结构，然后采用后序遍历输出。
 *
 * 备注:
 *
 * 输出数字以空格分隔
 */
public class 完全二叉树非叶子部分后序遍历 {
    private static Queue<Integer> queue = new ArrayDeque<>();
    private static Queue<Node> nodes = new ArrayDeque<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] ss = in.nextLine().split(" ");
        /*节点值存入队列*/
        for (String s : ss) {
            queue.add(Integer.parseInt(s));
        }
        /*构建二叉树*/
        Node root = build();
        /*移除所有叶子节点*/
        remove(root);
        List<String> p = new ArrayList<>();
        /*后序遍历打印*/
        print(root, p);
        System.out.println(String.join(" ", p));
    }
    /*构建二叉树*/
    public static Node build() {
        Node root = new Node(queue.poll());
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node top = nodes.poll();
            if (!queue.isEmpty()) {
                Node left = new Node(queue.poll());
                top.left = left;
                nodes.add(left);
            } else {
                break;
            }
            if (!queue.isEmpty()) {
                Node right = new Node(queue.poll());
                top.right = right;
                nodes.add(right);
            } else {
                break;
            }
        }
        return root;
    }
    /*删除叶子结点，只剩下非叶子节点
    *   1
    * 2   3
    * */
    public static Node remove(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        root.left = remove(root.left);
        root.right = remove(root.right);
        return root;
    }
    /*后续遍历打印*/
    public static void print(Node root, List<String> p) {
        if (root == null) {
            return;
        }
        print(root.left, p);
        print(root.right, p);
        p.add(String.valueOf(root.val));
    }
    static class Node {
        private int val;
        private Node left;
        private Node right;
        public Node() {
        }
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
