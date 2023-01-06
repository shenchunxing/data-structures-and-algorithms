package 树;

import common.TreeNode;

/**
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 */
public class 剑指Offer54_二叉搜索树的第k大节点 {
    /**
     * 二叉搜索树中序遍历是递增序列，则第k大的树可以反向中序遍历得到:右 -> 中 ->左
     */
    int k,ans;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null || k == 0) return;
        dfs(node.right);
        //遍历一个节点，需要k--，k变成0。得到的那个就是第k大的值
        if (--k == 0) ans = node.val;
        dfs(node.left);
    }
}
