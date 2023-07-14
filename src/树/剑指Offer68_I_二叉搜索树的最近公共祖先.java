package 树;

import common.TreeNode;

/**
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * 难度：简单
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
 */
/*2023-7-14*/
public class 剑指Offer68_I_二叉搜索树的最近公共祖先 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        System.out.println(lowestCommonAncestor(root,root.left,root.right));
    }
    //迭代O(n) O(1)
    static public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val) {
                root = root.right; // 直接覆盖，在右子树查找
            } else if (root.val > p.val && root.val > q.val) {
                root = root.left; // 直接覆盖，在左子树查找
            } else { //出现一左一右的情况，则root就是最近的祖先节点，直接跳出循环
                break;
            }
        }
        return root;
    }

    //递归O(n) O(n)
    static public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) { //p q都在右子树，则去右子树查找
            return lowestCommonAncestor2(root.right,p,q);
        }else if (root.val > p.val && root.val > q.val) { //p q都在左子树
            return lowestCommonAncestor2(root.left,p,q);
        }
        //p q一左一右的情况，root就是她们的最近公共祖先
        return root;
    }
}
