package 树;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 *
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 *
 * 两节点之间路径的 长度 由它们之间边数表示。
 *
 * 树、深度优先搜索、二叉树
 */
public class _543_二叉树的直径 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		_543_二叉树的直径 obj = new _543_二叉树的直径();
		System.out.println(obj.diameterOfBinaryTree(root));
	}

	 int ans = 1;
	/*路径的长度 = 经过的节点数 - 1*/
	 public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans - 1;
	 }

	 /*该方法返回是以root为节点的最大深度，深度越大，可能取到的节点数量也越多*/
	 public int depth(TreeNode node) {
		if (node == null) return 0;
		/*左右子节点的最大深度*/
		int l = depth(node.left);
		int r = depth(node.right);
		/*注意：这里是求和，并不是取较大值，所有左右子树的总节点， +1指的是本身的node节点*/
		ans = Math.max(ans, l + r  + 1);
		/*返回最大深度*/
		return Math.max(l, r) + 1;
	}
}
