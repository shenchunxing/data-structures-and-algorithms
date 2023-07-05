package 树;

import common.TreeNode;

/**
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 */
/*2023-7-5*/
public class _108_将有序数组转换为二叉搜索树 {
    public static void main(String[] args) {
        System.out.println(sortedArrayToBST(new int[] {-10,-3,0,5,9}));
    }
    static public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums,0,nums.length - 1);
    }

    static private TreeNode dfs(int[] nums, int left, int right) {
        /*递归出口：左下标 > 右下标*/
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums,left,mid - 1);
        root.right = dfs(nums,mid + 1,right);
        return root;
    }
}
