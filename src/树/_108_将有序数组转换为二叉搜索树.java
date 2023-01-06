package 树;

import common.TreeNode;

/**
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
 */
public class _108_将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums,0,nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums,left,mid - 1);
        root.right = dfs(nums,mid + 1,right);
        return root;
    }
}
