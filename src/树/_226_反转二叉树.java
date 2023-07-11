package 树;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 难度：简单
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
/*2023-7-11*/
public class _226_反转二叉树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        System.out.println(invertTree(root));
    }

    //时间复杂度O(n)，空间复杂度O(n)
    static public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        /*翻转左右子树*/
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        /*最后翻转以root为节点的左右子节点*/
        root.left = right;
        root.right = left;
        return root;
    }
}
