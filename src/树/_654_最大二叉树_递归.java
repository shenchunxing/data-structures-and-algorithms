package 树;

import java.util.Arrays;
import java.util.Stack;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 * 难度：中等
 * 给定一个不重复的整数数组nums 。最大二叉树可以用下面的算法从nums 递归地构建:
 * 创建一个根节点，其值为nums 中的最大值。
 * 递归地在最大值左边的子数组前缀上构建左子树。
 * 递归地在最大值右边的子数组后缀上构建右子树。
 * 返回nums 构建的 最大二叉树 。
 *
 */
/*2023-7-11*/
public class _654_最大二叉树_递归 {
	public static void main(String[] args) {
		int[] nums = {3,2,1,6,0,5};
		System.out.println(constructMaximumBinaryTree(nums));
	}
    static public TreeNode constructMaximumBinaryTree(int[] nums) {
    	if (nums == null) return null;
    	return findRoot(nums, 0, nums.length);
    }
    
    /**
     * 找出[l, r)范围的根节点
     */
    static private TreeNode findRoot(int[] nums, int l, int r) {
		/*说明已经是最后一个节点了，返回*/
    	if (l == r) return null;
    	
    	// 找出[l, r)范围内最大值的索引,记录索引的好处：可以同时拿到数组的索引和值
		/*默认最左边是最大值下标*/
    	int maxIdx = l;
    	for (int i = l + 1; i < r; i++) {
			if (nums[i] > nums[maxIdx]) maxIdx = i;
		}

		/*已经找到了整个数组的最大值所在的位置，构建树*/
    	TreeNode root = new TreeNode(nums[maxIdx]);
		/*该节点的左边区构建左子树，右半区构建右子树*/
    	root.left = findRoot(nums, l, maxIdx);
    	root.right = findRoot(nums, maxIdx + 1, r);
    	return root;
    }
}
