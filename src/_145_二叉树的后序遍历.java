import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/
 */
public class _145_二叉树的后序遍历 {
    /**
     * 迭代
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) { //中 右 左
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }
        //将中 右 左的结果倒序出来变成 左 右 中
        while (!stack2.isEmpty()) {
            res.add(stack2.pop().val);
        }
        return res;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public void postorder(TreeNode root, List<Integer> res) {
        if (root == null)  return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
}
