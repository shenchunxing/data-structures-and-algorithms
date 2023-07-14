package 树;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/
 * 难度：简单
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */
/*2023-7-14*/
public class 剑指Offer28_对称的二叉树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        /*递归*/
        System.out.println(isSymmetric(root));
        /*迭代：队列*/
        System.out.println(isSymmetric2(root));
    }

    //递归
    static public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }
    //依次检查左右子树的每个节点
    static private boolean check(TreeNode p , TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        /*p树的左节点和q树的右节点比较，p树的右节点和q树的左节点比较*/
        return p.val == q.val && check(p.left,q.right) && check(p.right,q.left);
    }

    //迭代，层序遍历
   static public boolean isSymmetric2(TreeNode root) {
       return check2(root,root);
    }

    static private boolean check2(TreeNode u , TreeNode v) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(u);
        queue.offer(v);
        while (!queue.isEmpty()) {
            u = queue.poll();
            v = queue.poll();
            /*如果两个都为空，不要直接return true，可能存在只有左子树或右子树的情况的*/
            if (u == null && v == null) continue;
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
