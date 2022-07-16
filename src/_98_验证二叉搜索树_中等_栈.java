import common.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/validate-binary-search-tree/
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 */
public class _98_验证二叉搜索树_中等_栈 {
    /**
     * 中序遍历的结果如果是递增的就是二叉搜索树 O(n) O(n)
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        double inorder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //中序遍历从小到大
            if (inorder >= root.val) return false;
            inorder = root.val;//保留当前值，下次可以比较
            root = root.right;
        }
        return true;
    }

    /**
     * 递归
     */
    public boolean isValidBST2(TreeNode root) {
        return isValidBST2(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 如果是二叉搜索树，则存在lower < node.val < upper
     */
    private boolean isValidBST2(TreeNode node, long lower, long upper) {
        if (node == null) return true;
        if (node.val <= lower || node.val >= upper) return false;
        //左子树：node.left < lower < node.val
        //右子树：node.right < node.val < upper
        return isValidBST2(node.left, lower, node.val) && isValidBST2(node.right, node.val, upper);
    }
}
