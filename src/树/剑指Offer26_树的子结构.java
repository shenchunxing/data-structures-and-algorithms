package 树;

import common.TreeNode;

/**
 * https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/
 * 难度：中等
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值
 */
/*2023-7-14*/
public class 剑指Offer26_树的子结构 {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(3);
        A.left = new TreeNode(4);
        A.right = new TreeNode(5);
        A.left.left = new TreeNode(1);
        A.left.right = new TreeNode(2);

        TreeNode B = new TreeNode(4);
        B.left = new TreeNode(1);

        System.out.println(isSubStructure(A,B));
    }

    static public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        //子树的根节点和A的根节点是同一个节点：recur(A,B)，先比较根节点是否相同，再比较左右子节点
        //子树的根节点在A的左子树：isSubStructure(A.left,B)
        //子树的根节点在A的右子树：isSubStructure(A.right,B)
        return recur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    /**
     * A和B的根节点是一样的，去比较左右子树是否一样即可
     * 因为B节点数量<=A,如果B遍历结束了，说明是子树
     * 如果A遍历提前结束了，说明不是
     * 如果A的节点值和B的节点值不相同，返回false
     */
    static boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null) return false;
        if (A.val != B.val) return false;
        return recur(A.left , B.left) && recur(A.right,B.right);
    }
}
