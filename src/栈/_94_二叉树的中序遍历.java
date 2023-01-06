package 栈;

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
        while (root!= null && !stack.isEmpty()) {
            while (root != null) {  //左到底。包括中间节点和左节点都入栈了
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();//出栈一个左
            ans.add(root.val);
            root = root.right;//右节点入栈，右节点如果不存在，则跳过内侧while，继续pop左节点
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
