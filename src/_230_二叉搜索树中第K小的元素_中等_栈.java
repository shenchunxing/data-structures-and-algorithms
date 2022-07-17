import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
 */
public class _230_二叉搜索树中第K小的元素_中等_栈 {
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
            k--;
            if (k == 0) break;
            root = root.right;
        }
        return root.val;
    }
}
