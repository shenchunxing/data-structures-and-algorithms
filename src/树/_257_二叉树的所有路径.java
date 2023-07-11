package 树;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * 难度：简单
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点
 */
/*2023-7-10*/
public class _257_二叉树的所有路径 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);

		System.out.println(binaryTreePaths(root));
	}
	static public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<>();
		constructPaths(root, "", paths);
		return paths;
    }

	/**
	 * @param root 当前遍历到的节点
	 * @param path 当前路径
	 * @param paths 总路径
	 */
	static private void constructPaths(TreeNode root , String path , List<String>paths) {
		/*到达了空节点，返回*/
		if (root == null) return;
		/*builder是为了拼接每个节点，形成一条完整路径*/
		StringBuilder builder  = new StringBuilder(path);
		/*遍历到当前节点*/
		builder.append(Integer.toString(root.val));
		/*已经遍历到了叶子节点，得到一个解*/
		if (root.left == null && root.right == null) {
			paths.add(builder.toString());
		}
		/*还没到叶子节点，继续深入*/
		else {
			builder.append("->");
			constructPaths(root.left, builder.toString(), paths);  //从左子树查找
			constructPaths(root.right, builder.toString(), paths); //从右子树查找
		}
	}
}
