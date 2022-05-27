import common.TreeNode;

import java.util.Deque;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/validate-binary-search-tree/
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 */
public class _98_验证二叉搜索树 {
    /**
     * 中序遍历的结果如果是递增的就是二叉搜索树 O(n) O(n)
     */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double inorder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) { //左子树走到底
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();//弹出栈顶
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) return false;
            inorder = root.val;//保留上一个弹出的值
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
