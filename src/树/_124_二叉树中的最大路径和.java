package 树;

import common.TreeNode;

/**
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/
 */
public class _124_二叉树中的最大路径和 {
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
        // 更新答案
        max_sum = Math.max(max_sum,price_newpath);
        // 当前节点作为子节点时的贡献：max(自己，自己+左边，自己+右边），不存在同时左右子树的原因是，题意要求自己只会经过一次
        return node.val + Math.max(left_gain,right_gain);
    }
}
