import common.TreeNode;

/**
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/
 */
public class _124_二叉树中的最大路径和_困难_dfs {
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
        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int price_newpath = node.val + left_gain + right_gain;
        // 更新答案
        max_sum = Math.max(max_sum,price_newpath);
        // 返回节点的最大贡献值
        return node.val + Math.max(left_gain,right_gain);
    }
}
