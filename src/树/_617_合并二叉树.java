package 树;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 * 难度：简单
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例1:
 *
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 */
public class _617_合并二叉树 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        TreeNode root = mergeTrees(root1,root2);
        System.out.println(root);
    }

    static public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        /*如果一个为null，直接使用剩余那个*/
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        /*创建新树的根节点*/
        TreeNode tree = new TreeNode(root1.val + root2.val);
        //合并左右子树
        tree.left =  mergeTrees(root1.left,root2.left);
        tree.right = mergeTrees(root1.right,root2.right);
        return tree;
    }
}
