import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class _226_反转二叉树_简单_递归 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
