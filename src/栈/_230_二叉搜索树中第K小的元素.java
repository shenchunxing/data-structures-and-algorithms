package 栈;

import common.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
 * 难度：中等
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）
 */
/*2023-7-10*/
public class _230_二叉搜索树中第K小的元素 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(kthSmallest(root,2));
    }
    /**
     * 中序遍历
     */
    static public int kthSmallest(TreeNode root, int k) {
       if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;//每次得到一个值，k--
            if (k == 0) break;//k == 0，root就是第k小的值
            root = root.right;
        }
        return root.val;
    }
}
