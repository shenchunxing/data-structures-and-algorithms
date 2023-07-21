package 栈;

import common.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/validate-binary-search-tree/
 * 难度：中等
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 */
/*2023-7-10*/
public class _98_验证二叉搜索树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(isValidBST(root));
    }
    //中序遍历的结果如果是递增的就是二叉搜索树 O(n) O(n)
   static public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        /*记录上一次遍历到的节点值，需要和当前节点进行比较，默认最小值*/
        double inorder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            /*先左到底，将左节点和左子节点全部入栈*/
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            /*root指的是当前遍历到的节点，最后的叶子左节点，先pop出来*/
            root = stack.pop();
            /*inorder指的是上一次遍历过的节点。中序遍历的特点是从小到大遍历，如果中间出现先遍历的>后遍历的，直接false*/
            if (inorder >= root.val) return false;
            /*更新上一次的节点*/
            inorder = root.val;
            /*更新当前节点*/
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
