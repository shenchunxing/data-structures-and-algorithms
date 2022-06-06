import common.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/construct-binary-search-tree-from-preorder-traversal/
 * 给定一个整数数组，它表示BST(即 二叉搜索树 )的 先序遍历 ，构造树并返回其根。
 */
public class _1008_前序遍历构造二叉搜索树 {
    //根据先序遍历直接构造出二叉树 O(nlogN)  O(n)
    public TreeNode bstFromPreorder(int[] preorder) {
        int len = preorder.length;
        if (len == 0) return null;
        return dfs(preorder,0,len - 1);
    }

    /**
     * 根据 preorder 的子区间 [left..right] 构建二叉树
     * @param preorder
     * @param left
     * @param right
     * @return
     */
    private TreeNode dfs(int[] preorder, int left, int right) {
        if (left > right) return null;
        TreeNode root = new TreeNode(preorder[left]);
        if (left == right) return root;
        // 在区间 [left..right] 里找最后一个小于 preorder[left] 的下标
        // 注意这里设置区间的左边界为 left ，不能是 left + 1
        // 这是因为考虑到区间只有 2 个元素 [left, right] 的情况，第 1 个部分为空区间，第 2 部分只有一个元素 right
        int l = left , r = right;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            // 下一轮搜索区间是 [mid, r]
            if (preorder[mid] < preorder[left]) {
                l = mid;
            } else {
                // 下一轮搜索区间是 [l, mid - 1]
                r = mid - 1;
            }
        }
        TreeNode leftTree = dfs(preorder,left + 1,l);
        TreeNode rightTree = dfs(preorder,l + 1,right);
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }

    //由于树是「二叉搜索树」，我们知道「二叉搜索树」的中序遍历的结果是有序序列。我们可以对「前序遍历」的结果 排序 得到「中序遍历」的结果
    public TreeNode bstFromPreorder2(int[] preorder) {
        int len = preorder.length;
        Map<Integer,Integer> map = new HashMap<>();
        int[] inorder = new int[len];
        //前序遍历数组拷贝到中序数组，并排序
        System.arraycopy(preorder,0,inorder,0,len);
        Arrays.sort(inorder);

        //记录每个节点的值和位置
        int index = 0;
        for (Integer value : inorder) {
            map.put(value,index);
            index++;
        }
        return dfs(0,len - 1,0,len - 1,preorder,map);
    }

    private TreeNode dfs(int preLeft , int preRight , int inLeft , int inRight, int[] preorder , Map<Integer,Integer> map) {
        if (preLeft > preRight || inLeft > inRight) return null;
        int pivot = preorder[preLeft];//根节点的值
        TreeNode root = new TreeNode(pivot);//创建根节点
        int pivotIndex = map.get(pivot); //根节点在中序遍历的位置，用以区分左右子树
        root.left = dfs(preLeft + 1,pivotIndex - inLeft + preLeft,
                inLeft , pivotIndex - 1,preorder,map);
        root.right = dfs(pivotIndex - inLeft + preLeft,preRight,
                pivotIndex + 1 , inRight,preorder,map);
        return root;
    }
}
