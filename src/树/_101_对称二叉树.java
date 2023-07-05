package 树;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/symmetric-tree/
 */
/*2023-7-5*/
public class _101_对称二叉树 {
    /**
     * 递归 O(n) O(n)
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root,root);
    }

    private boolean isSymmetric(TreeNode p , TreeNode q) {
        if (q == null && p == null) return true;
        if (q == null || p == null) return false;
        /*需要满足的条件：
        * 1.当前的值相等
        * 2.p树的左节点 == q树的右节点
        * 3.p树的右节点 == q树的左节点*/
        return p.val == q.val && isSymmetric(p.left,q.right) && isSymmetric(p.right,q.left);
    }

    /**
     * 迭代 O(n) O(n)
     */
    public boolean isSymmetric2(TreeNode root) {
        return isSymmetric2(root,root);
    }

    /**
     * 比较两颗一样的树：原理是按照queue的加入顺序，p、q的根节点。然后是p的左节点、q的右节点。。。
     */
    private boolean isSymmetric2(TreeNode p , TreeNode q) {
       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(p);
       queue.offer(q);
       while (!queue.isEmpty()) {
           p = queue.poll();
           q = queue.poll();
           if (p == null && q == null) continue;
           if (p == null || q == null) return false;
           if (p.val != q.val) return false;
           queue.add(p.left);
           queue.add(q.right);
           queue.add(p.right);
           queue.add(q.left);
       }
        return true;
    }
}

