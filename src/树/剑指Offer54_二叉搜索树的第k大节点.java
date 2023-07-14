package 树;

import common.TreeNode;

/**
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * 难度：简单
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 */
/*2023-7-14*/
public class 剑指Offer54_二叉搜索树的第k大节点 {
    public static void main(String[] args) {
        剑指Offer54_二叉搜索树的第k大节点 o = new 剑指Offer54_二叉搜索树的第k大节点();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        System.out.println(o.kthLargest(root,1));
    }
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
        /*遍历结束或者已经找到了最大值,退出递归*/
        if (node == null || k == 0) return;
        /*先遍历右节点*/
        dfs(node.right);
        //遍历一个节点，需要k--，k变成0。得到的那个就是第k大的值
        if (--k == 0) ans = node.val;
        /*遍历左节点*/
        dfs(node.left);
    }
}
