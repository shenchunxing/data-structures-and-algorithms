package 树;

import common.TreeNode;

/**
 * https://leetcode.cn/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */
public class 剑指Offer68_II_二叉树的最近公共祖先 {
    /**
     * 去以root为根节点的二叉树中查找p、q的最近公共祖先
     * ① 如果p、q同时存在于这棵二叉树中，就能成功返回它们的最近公共祖先
     * ② 如果p、q都不存在于这棵二叉树中，返回null
     * ③ 如果只有p存在于这棵二叉树中，返回p
     * ④ 如果只有q存在于这棵二叉树中，返回q
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //这里 root == p || root == q。说明本身节点就是祖先节点，可以提早结束递归。
        if (root == null || root == p || root == q) return root;
        // 去以root.left为根节点的二叉树中查找p、q的最近公共祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 去以root.right为根节点的二叉树中查找p、q的最近公共祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //左右子树都没找到，说明root才是公共祖先
        if (left != null && right != null) return root;
        //左右子树一个找到一个没找到，说明找到的那个就是公共祖先
        return (left != null) ? left : right;
    }
}
