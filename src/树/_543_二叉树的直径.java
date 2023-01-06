package 树;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * @author shenchunxing
 *
 */
public class _543_二叉树的直径 {
	 int ans = 1;
	 public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
	 }
	 
	 /**
	  * 获取最大的节点的深度的同时，保存最大直径
	  * @param node
	  * @return
	  */
	 public int depth(TreeNode node) {
		if (node == null) return 0;
		int l = depth(node.left);
		int r = depth(node.right);
		ans = Math.max(ans, l + r  + 1);
		return Math.max(l, r) + 1;
	}
}
