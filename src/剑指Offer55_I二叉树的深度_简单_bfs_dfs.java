import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/
 */
public class 剑指Offer55_I二叉树的深度_简单_bfs_dfs {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    //BFS:层序遍历
    public int maxDepth3(TreeNode root) {
        if(root == null) return 0;
        List<TreeNode> queue = new LinkedList<>();
        List<TreeNode> tmp = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while(!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for(TreeNode node : queue) {
                if(node.left != null) tmp.add(node.left);
                if(node.right != null) tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }
}
