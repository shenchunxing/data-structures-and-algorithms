package 树;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 剑指Offer28_对称的二叉树 {
    //递归
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }
    //依次检查左右子树的每个节点
    private boolean check(TreeNode p , TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && check(p.left,q.left) && check(p.right,q.right);
    }

    //迭代
    public boolean isSymmetric2(TreeNode root) {
       return check2(root,root);
    }

    private boolean check2(TreeNode u , TreeNode v) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(u);
        queue.offer(v);
        while (!queue.isEmpty()) {
            u = queue.poll();
            v = queue.poll();
            if (u == null && v == null) continue;//如果两个都为空，不要直接return true，可能存在只有左子树或右子树的情况的
            //队列中两个连续的节点应该是相等的，如果有一个为空，或者两者不相同，直接false
            if ((u == null || v == null) || (u.val != v.val)) return false;
            //按对称的顺序入队
            queue.offer(u.left);
            queue.offer(v.right);
            queue.offer(u.right);
            queue.offer(v.left);
        }
        return true;
    }
}
