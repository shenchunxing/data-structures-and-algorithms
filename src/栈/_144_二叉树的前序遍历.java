package 栈;

import common.TreeNode;

import java.util.*;

/**
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 */
/*2023-7-4*/
public class _144_二叉树的前序遍历 {
    public static void main(String[] args) {
        // 构建一棵二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // 测试 preorderTraversal 函数
        List<Integer> result = preorderTraversal(root);
        System.out.println(result);  // 输出: [1, 2, 4, 5, 3]
    }
    /**
     * 迭代
     */
    static public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            /*pop当前节点，并添加到ans中*/
            TreeNode node = stack.pop();
            ans.add(node.val);
            /*先push当前节点的右节点，pop的时候后面才pop*/
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
     * 递归：先左子树，再右子树
     */
    static public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        return traversal(root,list);
    }

    static private List<Integer> traversal(TreeNode root , List list) {
        if (root == null) return list;
        list.add(root.val);
        if (root.left != null) traversal(root.left,list);
        if (root.right != null) traversal(root.right,list);
        return list;
    }
}
