package 栈;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/
 */
/*2023-7-5*/
public class _145_二叉树的后序遍历 {
    public static void main(String[] args) {
        // 构建一棵二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // 测试 postorderTraversal 函数
        List<Integer> result = postorderTraversal(root);
        System.out.println(result);  // 输出: [4,5,2,3,1]
    }
    /**
     * 迭代:双栈
     */
    static public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        /*stack1用于push节点，stack2用于pop节点*/
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) { //存入stack1的顺序：中 左 右，存入stack2的顺序：中 右 左
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }
        //stack2的pop顺序：左 右 中
        while (!stack2.isEmpty()) {
            ans.add(stack2.pop().val);
        }
        return ans;
    }

    /**
     * 递归；先左右，再中间
     * @param root
     * @return
     */
    static public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    static public void postorder(TreeNode root, List<Integer> res) {
        if (root == null)  return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
}
