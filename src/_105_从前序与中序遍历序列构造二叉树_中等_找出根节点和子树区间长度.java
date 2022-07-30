import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class _105_从前序与中序遍历序列构造二叉树_中等_找出根节点和子树区间长度 {
    // 我们可以用一个HashMap把中序遍历数组的每个元素的值和下标存起来，这样寻找根节点的位置就可以直接得到了
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return dfs(preorder,0,preorder.length,inorder,0,inorder.length,map);
    }

    private TreeNode dfs(int[] preorder, int p_start , int p_end , int[] inorder, int i_start , int i_end ,Map<Integer,Integer> map) {
        if (p_start == p_end) return null;
        int root_val = preorder[p_start]; // 前序遍历的第一个值就是根节点的值
        TreeNode root = new TreeNode(root_val);//创建根节点
        //在中序遍历中找到根节点的值
        int i_root_index = map.get(root_val);
        int leftNum = i_root_index - i_start;  //左子树的节点数量
        //递归构建左子树:
        //前序：[p_start + 1,p_start + leftNum + 1)
        //中序: [i_start，i_root_index)
        root.left = dfs(preorder,p_start + 1,p_start + leftNum + 1,inorder,i_start,i_root_index,map);
        //递归构建右子树
        root.right = dfs(preorder,p_start + 1 + leftNum,p_end,inorder,i_root_index + 1,i_end,map);
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return dfs2(preorder,0,preorder.length,inorder,0,inorder.length);
    }

    // 但存在一个问题，在中序遍历中找到根节点的位置每次都得遍历中序遍历的数组去寻找。
    private TreeNode dfs2(int[] preorder, int p_start , int p_end , int[] inorder, int i_start , int i_end) {
        if (p_start == p_end) return null;
        int root_val = preorder[p_start]; // 前序遍历的第一个值就是根节点的值
        TreeNode root = new TreeNode(root_val);//创建根节点
        //在中序遍历中找到根节点的值
        int i_root_index = 0;
        for (int i = i_start; i < i_end; i++) {
            if (root_val == inorder[i]) {
                i_root_index = i;
                break;
            }
        }

        int leftNum = i_root_index - i_start;  //左子树的节点数量
        //递归构建左子树:
           //前序：[p_start + 1,p_start + leftNum + 1)
           //中序: [i_start，i_root_index)
        root.left = dfs2(preorder,p_start + 1,p_start + leftNum + 1,inorder,i_start,i_root_index);
        //递归构建右子树
        root.right = dfs2(preorder,p_start + 1 + leftNum,p_end,inorder,i_root_index + 1,i_end);
        return root;
    }
}
