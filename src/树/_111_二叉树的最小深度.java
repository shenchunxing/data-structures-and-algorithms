package 树;
/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * @author shenchunxing
 *
 */
import common.TreeNode;
public class _111_二叉树的最小深度 {
	
	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		if (root.left == null && root.right == null) return 1;
		int min = Integer.MAX_VALUE; //不能设置为1，因为在递归的
		//左子树的最小深度
		if (root.left != null) min = Math.min(min,minDepth(root.left));
		if (root.right != null) min = Math.min(min,minDepth(root.right));
		//左右子树最小的深度+1
		return min + 1;
    }
}
