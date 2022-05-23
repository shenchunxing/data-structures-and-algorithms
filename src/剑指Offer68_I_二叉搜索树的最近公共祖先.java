import common.TreeNode;

/**
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */
public class 剑指Offer68_I_二叉搜索树的最近公共祖先 {
    //迭代O(n) O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) { //p q都在右子树，则去右子树查找
            return lowestCommonAncestor2(root.right,p,q);
        }else if (root.val > p.val && root.val > q.val) { //p q都在左子树
            return lowestCommonAncestor2(root.left,p,q);
        }
        //p q一左一右的情况，root就是她们的最近公共祖先
        return root;
    }
}
