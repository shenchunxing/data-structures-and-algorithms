package 树;

import java.util.Arrays;
import java.util.Stack;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 * 
 * @author MJ
 *
 */
public class _654_最大二叉树_递归 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
    	if (nums == null) return null;
    	return findRoot(nums, 0, nums.length);
    }
    
    /**
     * 找出[l, r)范围的根节点
     */
    private TreeNode findRoot(int[] nums, int l, int r) {
    	if (l == r) return null;
    	
    	// 找出[l, r)范围内最大值的索引
    	int maxIdx = l;
    	for (int i = l + 1; i < r; i++) {
			if (nums[i] > nums[maxIdx]) maxIdx = i;
		}
    	
    	TreeNode root = new TreeNode(nums[maxIdx]);
    	root.left = findRoot(nums, l, maxIdx); //构建左最大二叉树
    	root.right = findRoot(nums, maxIdx + 1, r);//构建右最大二叉树
    	return root;
    }
}
