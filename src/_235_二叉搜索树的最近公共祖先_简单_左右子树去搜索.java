import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * @author shenchunxing
 *
 */
public class _235_二叉搜索树的最近公共祖先_简单_左右子树去搜索 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode ans = root;
		while (true) {
			if (p.val < ans.val && q.val < ans.val) {
				ans = ans.left; //祖先在左子树
			} else if (p.val > ans.val && q.val > ans.val) {
				ans = ans.right;
			} else { //祖先就是ans
				break;
			}
		}
		return ans;
	}
}
