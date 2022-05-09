import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * @author shenchunxing
 *
 */
public class _235_二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode ansNode = root;
		while (true) {
			//去左子树查找
			if (p.val < ansNode.val && q.val < ansNode.val) {
				ansNode = ansNode.left;
			}
			//去右子树查找
			else if (p.val > ansNode.val && q.val > ansNode.val) {
				ansNode = ansNode.right;
			} else { //ans 介于 p、q的值之间，就是祖先节点
				break;
			}
		}
		return ansNode;
	}
}
