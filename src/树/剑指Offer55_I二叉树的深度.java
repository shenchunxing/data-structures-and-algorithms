package 树;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/
 * 本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 难度：简单
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 */
/*2023-7-14*/
public class 剑指Offer55_I二叉树的深度 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        /*递归*/
        System.out.println(maxDepth(root));
        /*BFS*/
        System.out.println(maxDepth3(root));
    }

   static public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        /*左右子树的高度较大值 + 1*/
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    //BFS:层序遍历，注意这里是遍历一层，ans++
    static public int maxDepth3(TreeNode root) {
        if(root == null) return 0;
        List<TreeNode> queue = new LinkedList<>();
        List<TreeNode> tmp;
        queue.add(root);
        int ans = 0;
        while(!queue.isEmpty()) {
            tmp = new LinkedList<>();
            /*当期层的所有子节点*/
            for(TreeNode node : queue) {
                if(node.left != null) tmp.add(node.left);
                if(node.right != null) tmp.add(node.right);
            }
            queue = tmp;
            /*每遍历一层，ans++*/
            ans++;
        }
        return ans;
    }
}
