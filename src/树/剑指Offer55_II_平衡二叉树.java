package 树;

import com.mj.printer.LevelOrderPrinter;

import common.TreeNode;

/**
 * https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/
 */
public class 剑指Offer55_II_平衡二叉树 {

    // TODO:递归
    public boolean isBalanced2(TreeNode root) {
        if (root == null) return true;
        /**
         * 需要满足3个条件：
         *  1.以root为根节点的二叉树是平衡树
         *  2.root的左节点为根节点的二叉树是平衡树
         *  3.root的右节点为根节点的二叉树是平衡树
         */
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced2(root.left) && isBalanced2(root.right);
    }

    /*获取节点的深度*/
    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left),depth((root.right))) + 1;
    }

    //后序遍历:自底向上，提前剪支提前剪枝
    public boolean isBalanced(TreeNode root) {
        //-1表示不是平衡树
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if (left == -1) return -1; //如果左右子树深度为-1，说明不是平衡树，直接剪枝，返回-1
        int right = recur(root.right);
        if (right == -1) return -1;
        //左右节点的深度差<=1,则返回当前子树的深度
        //左右节点的深度差 > 1,则返回-1，代表该子树不是平衡树
        return Math.abs(left - right) < 2 ? Math.max(left,right) + 1 : -1;
    }
}
