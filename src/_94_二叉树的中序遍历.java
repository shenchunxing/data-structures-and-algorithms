import common.TreeNode;

import java.util.*;

/**
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/
 */
public class _94_二叉树的中序遍历 {
    //迭代O(n) O(n)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        //[4,2,5,1,6,3]
        while (root != null && !stack.isEmpty()) {
            while (root != null) { //先将左节点全部入栈
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();//出栈
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }

    /**
     * 递归 O(n) O(n)
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root,ans);
        return ans;
    }

    private void inorder(TreeNode root , List<Integer> ans) {
        if (root == null) return;
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }
}
