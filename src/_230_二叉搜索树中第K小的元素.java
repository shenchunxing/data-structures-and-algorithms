import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
 */
public class _230_二叉搜索树中第K小的元素 {
    /**
     * 中序遍历
     */
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop(); //弹出一个，减少一个
            --k;
            if (k == 0) break; //找到了
            root = root.right;
        }
        return root.val;
    }
}
