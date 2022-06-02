import common.TreeNode;

/**
 * https://leetcode.cn/problems/convert-bst-to-greater-tree/
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node的新值等于原树中大于或等于node.val的值之和。
 */
public class _538_把二叉搜索树转换为累加树 {
    //递归：二叉搜索树的反向中序遍历：单调递减序列
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return root;
        convertBST(root.right);
        sum += root.val;
        root.val = sum; //变成新值
        convertBST(root.left);
        return root;
    }
}
