import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 * 给定两个整数数组，preorder和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵树的后序遍历，重构并返回二叉树。
 */
public class _889_根据前序和后序遍历构造二叉树 {
    public static void main(String[] args) {
        _889_根据前序和后序遍历构造二叉树 o = new  _889_根据前序和后序遍历构造二叉树();
        System.out.println(o.constructFromPrePost(new int[] {1,2,4,5,3,6,7},new int[] {4,5,2,6,7,3,1}));
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = postorder.length;
        for (int i = 0; i < n; i++) { //记录后序遍历的值和下标
            map.put(postorder[i] , i);
        }
        return dfs(preorder,0,n - 1,postorder,0,n - 1,map);
    }

    private TreeNode dfs(int[] preorder , int pre_start , int pre_end , int[] postorder , int post_start , int post_end , Map<Integer ,Integer> map) {
        if (pre_start > pre_end) return null;
        TreeNode root = new TreeNode(preorder[pre_start]); //前序遍历第一个节点就是根节点
        if (pre_start == pre_end) return root; //只剩下了一个节点，得到一个解
        //找到后序遍历左子树的根节点位置
        int l_root_index = map.get(preorder[pre_start + 1]);
        //后序遍历左子树的长度
        int l_size = l_root_index - post_start + 1;
        root.left = dfs(preorder, pre_start + 1, pre_start + l_size, postorder, post_start, l_root_index, map);
        root.right = dfs(preorder, pre_start + l_size + 1, pre_end, postorder, l_root_index + 1, post_end - 1, map);
        return root;
    }
}
