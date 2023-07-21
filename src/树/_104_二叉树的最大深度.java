package 树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 难度：简单
 * 给定一个二叉树，找出其最大深度。
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
说明:叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，
    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度3 。
 */
/*2023-7-5*/
public class _104_二叉树的最大深度 {
	public static void main(String[] args) {
		// 构建一棵二叉树
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		// 测试 maxDepth1 函数
		int result = maxDepth1(root);
		int result2 = maxDepth2(root);
		System.out.println(result);  // 输出: [1，2，3，4，5]
		System.out.println(result2);  // 输出: [1，2，3，4，5]
	}
	
	//递归：左右子树的较高者 + 1(后序遍历).+1是因为有个根节点
	static public int maxDepth1(TreeNode root) {
		if (root == null) return 0;
		int leftDepth = maxDepth1(root.left);
		int rightDepth = maxDepth1(root.right);
		return Math.max(leftDepth, rightDepth) + 1;
    }

	//bfs：二叉树的层级遍历
	static public int maxDepth2(TreeNode root) {
		if (root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>(); //队列里面存放的是当前层的所有节点
		queue.add(root);
		int ans = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			//每一轮都把该层元素清空。进入下一层
			while (size > 0) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				size --;
			}
			ans ++;//走完一层，ans++
		}
		return ans;
	}
}









