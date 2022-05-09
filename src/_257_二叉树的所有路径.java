import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * @author shenchunxing
 *
 */
public class _257_二叉树的所有路径 {
	public List<String> binaryTreePaths(TreeNode root) {

		List<String> paths = new ArrayList<>();
		constructPaths(root, "", paths);
		
		return paths;
    }
	
	private void constructPaths(TreeNode root , String path , List<String>paths) {
		if (root == null) return;
		StringBuilder builder  = new StringBuilder(path);
		builder.append(Integer.toString(root.val)); //拼接根节点的值
		if (root.left == null && root.right == null) { //已经到了叶子节点
			paths.add(builder.toString());
		}
		else {
			builder.append("->");
			constructPaths(root.left, builder.toString(), paths);  //从左子树查找
			constructPaths(root.right, builder.toString(), paths); //从右子树查找
		}
	}
}
