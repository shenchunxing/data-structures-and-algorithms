package 栈;

import common.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
 */
public class _230_二叉搜索树中第K小的元素 {
    /**
     * 中序遍历
     */
    public int kthSmallest(TreeNode root, int k) {
       if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;//每次得到一个值，k--
            if (k == 0) break;//k == 0，root就是第k小的值
            root = root.right;
        }
        return root.val;
    }
}
