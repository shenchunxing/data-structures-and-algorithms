import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/same-tree/
 * @author shenchunxing
 *
 */
public class _100_相同的树 {
	 public boolean isSameTree(TreeNode p, TreeNode q) {
		 if (p == null && q == null) return true;
		 if (p== null && q != null) return false;
		 if (p != null && q == null) return false;
		 if (p.val != q.val) return false;
		 return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	 }
}
