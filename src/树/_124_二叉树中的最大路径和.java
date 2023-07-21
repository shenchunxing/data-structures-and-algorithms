package 树;

import common.TreeNode;

/**
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class _124_二叉树中的最大路径和 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        _124_二叉树中的最大路径和 object = new _124_二叉树中的最大路径和();
        System.out.println(object.maxPathSum(root));
    }

    int max_sum = Integer.MIN_VALUE ;
    public int maxPathSum(TreeNode node) {
        max_gain(node);
        return max_sum;
    }

    private int max_gain(TreeNode node) {
        if (node == null) return 0;
        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int left_gain = Math.max(max_gain(node.left),0);
        int right_gain = Math.max(max_gain(node.right),0);
        // 当前节点的最大路径： max(自己，自己+左边，自己+右边，自己 + 左边 + 右边）
        int price_newpath = node.val + left_gain + right_gain;
        // 更新以root作为根节点的情况下获取到的最大路径和
        max_sum = Math.max(max_sum,price_newpath);
        // 返回当前节点 node 作为子节点时的最大贡献值，即 node.val + max(left_gain, right_gain)。这样是因为从父节点经过当前节点时，只能选择左子树或右子树的路径中的较大者。
        return node.val + Math.max(left_gain,right_gain);
    }
}
