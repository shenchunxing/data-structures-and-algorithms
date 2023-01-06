package 树;

import common.TreeNode;

/*
https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/
 */
public class 剑指Offer26_树的子结构 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        //子树的根节点和A的根节点是同一个节点：recur(A,B)，先比较根节点是否相同，再比较左右子节点
        //子树的根节点在A的左子树：isSubStructure(A.left,B)
        //子树的根节点在A的右子树：isSubStructure(A.right,B)
        return recur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    /*判断以A为根节点的子树是否包含B*/
    boolean recur(TreeNode root, TreeNode B) {
        if (B == null) return true;
        if (root == null || root.val != B.val) return false;
        return recur(root.left , B.left) && recur(root.right,B.right);
    }
}
