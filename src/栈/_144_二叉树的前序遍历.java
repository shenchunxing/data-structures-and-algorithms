package 栈;

import common.TreeNode;

import java.util.*;

/**
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 */
public class _144_二叉树的前序遍历 {
    /**
     * 迭代
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return ans;
    }
    /**
     * 递归
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        return traversal(root,list);
    }

    private List<Integer> traversal(TreeNode root , List list) {
        if (root == null) return list;
        list.add(root.val);
        if (root.left != null) traversal(root.left,list);
        if (root.right != null) traversal(root.right,list);
        return list;
    }
}
