/**
 * https://leetcode.cn/problems/house-robber-iii/
 */
import com.sun.source.tree.Tree;
import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _337_打家劫舍III {
    /**
     * 简化题意：一棵二叉树，树上的每个点都有对应的权值，每个点有两种状态（选中和不选中）
     * 在不能同时选中有父子关系的点的情况下，能选中的点的最大权值和是多少
     */
    //因为f和g都只和l、r有关，可以设置一个滚动数组,保存选中和不选中的结果
    public int rob(TreeNode root) {
        int[] rootStatus = dfs(root);
        return Math.max(rootStatus[0],rootStatus[1]);
    }

    //l表示左子树，选中和不选中
    //r表示右子树，选中和不选中
    private int[] dfs(TreeNode node) {
        if (node == null) return new int[] {0,0};
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        int selected = node.val + l[1] + r[1];//node.val + 左右子树不被选中的权值和
        int noselected = Math.max(l[0],l[1]) + Math.max(r[0],r[1]);//左右子树选不选中的较大值相加
        return new int[] {selected,noselected};
    }

    //动态规划
    //f(o)表示选择o节点的情况下,o节点的子树上被选择的节点的最大权值和
    //g(o)表示不选择o节点的情况下,o节点的子树上被选择的节点的最大权值和
    //f(o) = o.value + g{l}+ g(r) //o被选中，则l和r都不能被选中的最大权值和
    //g(o) = max{f(l) , g(l)} + max{f(r) , g(r)} //o不被选中，则l和r都是可选可不选
    public int rob1(TreeNode root) {
        Map<TreeNode,Integer> f = new HashMap<>();
        Map<TreeNode,Integer> g = new HashMap<>();
        dfs1(root,f,g);
        //比较f(root) 和 g(root)
        return Math.max(f.getOrDefault(root,0),g.getOrDefault(root,0));
    }
    private void dfs1(TreeNode node,Map<TreeNode,Integer> f , Map<TreeNode,Integer> g) {
        if (node == null) return;
        //后序遍历，为了先拿到左右子树的权值和
        dfs1(node.left,f,g);
        dfs1(node.right,f,g);
        f.put(node,node.val + g.getOrDefault(node.left,0) + g.getOrDefault(node.right,0));
        g.put(node,
                Math.max(
                   f.getOrDefault(node.left,0),
                   g.getOrDefault(node.left,0)) +
                Math.max(
                   f.getOrDefault(node.right,0),
                   g.getOrDefault(node.right,0)));
    }
}
