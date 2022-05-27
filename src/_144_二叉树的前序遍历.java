import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 */
public class _144_二叉树的前序遍历 {
    /**
     * 迭代
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root); //首先根节点入队
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val); //打印根节点
            if (node.right != null) stack.push(node.right);//先入队右节点，再左节点， 这样pop的时候先pop左节点
            if (node.left != null) stack.push(node.left);
        }
        return list;
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
