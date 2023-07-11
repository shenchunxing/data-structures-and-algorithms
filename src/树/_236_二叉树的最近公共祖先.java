package 树;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 难度：中等
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
/*2023-7-11*/
public class _236_二叉树的最近公共祖先 {
    public static void main(String[] args) {
        // 构造二叉树
        /*         3
              5         1
           6    2    0    8
              7   4
        * */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // 测试
        TreeNode p = root.left; //5
        TreeNode q = root.left.right.right;//4
        TreeNode lowestCommonAncestor = lowestCommonAncestor(root, p, q);
        System.out.println("最近公共祖先: " + lowestCommonAncestor.val);
    }
    /**
     * 去以root为根节点的二叉树中查找p、q的最近公共祖先
     * ① 如果p、q同时存在于这棵二叉树中，就能成功返回它们的最近公共祖先
     * ② 如果p、q都不存在于这棵二叉树中，返回null
     * ③ 如果只有p存在于这棵二叉树中，返回p
     * ④ 如果只有q存在于这棵二叉树中，返回q
     */
    static public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //p或者q为根节点的情况：root就是最近公共祖先
        if (root == null || root == p || root == q) return root;
        // 以root.left为根节点的二叉树中查找p、q的最近公共祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 以root.right为根节点的二叉树中查找p、q的最近公共祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //左右子树都没有找到，则root就是最近公共祖先
        if (left != null && right != null) return root;
        //只有一边可以找到，那一边的根节点就是最近公共祖先
        return (left != null) ? left : right;
    }
}
