package 树;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 */
public class _99_恢复二叉搜索树 {
    // 中序遍历：时间复杂度O(n)、空间复杂度O(1)
    /**
     * 上一次中序遍历过的节点
     */
    private TreeNode prev;
    /**
     * 第一个错误节点
     */
    private TreeNode first;
    /**
     * 第二个错误节点
     */
    private TreeNode second;

    private void find(TreeNode node) {
        // 出现了逆序对
        if (prev != null && prev.val > node.val) {
            // 第2个错误节点：最后一个逆序对中较小的那个节点，会覆盖以前的较小节点
            second = node;

            // 第1个错误节点：第一个逆序对中较大的那个节点
            if (first != null) return;
            first = prev;
        }
        prev = node;
    }

    //Mirrors遍历，时间复杂度O(n)，空间复杂度O(1)
    public void recoverTree(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                // 找到前驱节点(predecessor)
                TreeNode pred = node.left;
                //因为后续会设置pred.right = node，所以循环需要加上pred.right != node
                while (pred.right != null && pred.right != node) {
                    pred = pred.right;
                }

                //第一次遍历到前驱节点需要设置pred.right = node
                if (pred.right == null) {
                    pred.right = node;
                    node = node.left;
                } else { // 第二次遍历到前驱节点，已经是pred.right == node
                    find(node);
                    //还原二叉树的结构
                    pred.right = null;
                    //遍历下一个节点
                    node = node.right;
                }
            } else {
                find(node);
                node = node.right;
            }
        }

        // 交换2个错误节点的值
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    /**
     * @param root 是一棵错误的二叉搜索树（有2个节点被错误交换）
     *  递归：时间复杂度O(n),空间复杂度O(树的高度)
     */
    public void recoverTree1(TreeNode root) {
        findWrongNodes(root);
        // 交换2个错误节点的值
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void findWrongNodes(TreeNode root) {
        if (root == null) return;
        findWrongNodes(root.left);
        find(root);
        findWrongNodes(root.right);
    }
}
