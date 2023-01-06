package DFS;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 剑指Offer34_二叉树中和为某一值的路径 {
    //最优解：回溯（dfs）
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        dfs(root,sum,new ArrayList<>(),lists);
        return lists;
    }

    /**
     * 递归搜索符合remain的情况
     */
    private void dfs(TreeNode node, int remain , List<Integer> nums , List<List<Integer>> lists) {
        if (node == null) return;//节点超过了叶子节点，退出递归
        remain -= node.val; //选中当前的node节点值，需要减去
        nums.add(node.val);//添加到答案
        if (node.left == null && node.right == null) { //当前节点已经是根节点
            if (remain == 0) lists.add(new ArrayList<>(nums)); //当remain为0的时候，得到一个解
        } else  { //递归左右子树
            dfs(node.left,remain,nums,lists);
            dfs(node.right,remain,nums,lists);
        }
        nums.remove(nums.size() - 1); //回溯：删掉上一个val
    }
}
