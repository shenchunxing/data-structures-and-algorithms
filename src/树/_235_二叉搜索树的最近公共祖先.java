package 树;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 难度：中等
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5]
 */
/*2023-7-11*/
public class _235_二叉搜索树的最近公共祖先 {
	public static void main(String[] args) {
		// 构造二叉树
        /*         6
              2         8
           0    4    7    9
              3   5
        * */
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);

		// 测试
		TreeNode p = root.left.right.left; //3
		TreeNode q = root.left.right.right;//5
		TreeNode lowestCommonAncestor = lowestCommonAncestor(root, p, q);
		System.out.println("二叉搜索树的最近公共祖先: " + lowestCommonAncestor.val);
	}

    static public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		/*默认根节点*/
		TreeNode ans = root;
		while (true) {
			/*祖先在左子树，继续从左子树查找。因为是二叉搜索树，才能这么比较*/
			if (p.val < ans.val && q.val < ans.val) {
				ans = ans.left;
				/*祖先在右子树，继续从右子树查找*/
			} else if (p.val > ans.val && q.val > ans.val) {
				ans = ans.right;
				/*祖先就是当前的ans节点，直接返回*/
			} else {
				return ans;
			}
		}
	}
}
