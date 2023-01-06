package 树;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class _106_从中序与后序遍历序列构造二叉树 {
    int post_idx;
    //O(n) O(n)
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        //后序遍历的最后一个节点就是根节点
        post_idx = postorder.length - 1;
        int idx = 0;
        //根据中序遍历，建立元素和下标的映射
        for (Integer val : inorder) {
            map.put(val,idx);
            idx++;
        }
        return dfs(0,inorder.length - 1  ,inorder , postorder,map);
    }

    /**
     * 左右区间构建二叉树,post_idx为当前子树的根节点下标
     */
    private TreeNode dfs(int left , int right, int[] inorder, int[] postorder, Map<Integer,Integer> map) {
        if (left > right) return null;
        //建立根节点
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);
        //找到子树的根节点在数组中的位置，分成左右子树
        int index = map.get(root_val);
        //下标--，将root从下一个循环中排除出去
        post_idx--;
        //构建左右子树
        root.right = dfs(index + 1 , right , inorder , postorder,map);
        root.left = dfs(left , index - 1 , inorder , postorder,map);
        return root;
    }
}
