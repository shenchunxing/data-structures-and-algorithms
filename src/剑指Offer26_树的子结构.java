import common.TreeNode;

/*
https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/
 */
public class 剑指Offer26_树的子结构 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        //子树的根节点可能A的左右子树，或者就在A的根节点
        return recur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    /*判断以A为根节点的子树是否包含b*/
    boolean recur(TreeNode root, TreeNode B) {
        if (B == null) return true;
        if (root == null || root.val != B.val) return false;
        return recur(root.left , B.left) && recur(root.right,B.right);
    }
}
