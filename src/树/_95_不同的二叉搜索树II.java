package 树;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/unique-binary-search-trees-ii/
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案
 */
public class _95_不同的二叉搜索树II {
    public static void main(String[] args) {
        _95_不同的二叉搜索树II ob = new _95_不同的二叉搜索树II();
        System.out.println(ob.generateTrees(3));
    }
    //递归：以i为根节点的二叉搜索树时递归找到左子树的结合和右子树的集合，然后两个结合笛卡尔积得到以为根节点的总集合；然后循环找到i的所有值
    public List<TreeNode> generateTrees(int n) {
        return dfs(1,n);
    }

    /**
     * 尝试以i为根节点，去生成二叉搜索树
     * @param start 最小数字
     * @param end 最大数字
     * @return
     */
    private List<TreeNode> dfs(int start , int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {
            //左子树集合
            List<TreeNode> lefts = dfs(start , i - 1);
            //右子树集合
            List<TreeNode> rights = dfs(i + 1,end);
            //左子树选一种右子树选一种进行组合
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                   TreeNode node = new TreeNode();
                   node.val = i; //根节点
                   node.left = left; //左子树
                   node.right = right;//右子树
                   list.add(node);
                }
            }
        }
        return list;
    }
}
