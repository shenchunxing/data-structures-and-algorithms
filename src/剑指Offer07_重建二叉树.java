import common.TreeNode;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/
 */
public class 剑指Offer07_重建二叉树 {
    /**
     * 前序遍历的第一个节点就是很节点
     * 中序遍历找到根节点，可以划分左右子树
     * 前序遍历找到根节点后，下一个节点就是左子树的根节点，根节点+左子树的长度就是右子树的根节点
     */
    int[] preorder;
    HashMap<Integer ,Integer> map = new HashMap<>();//哈希表用于记录中序遍历的节点
    //O(n) O(n)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) { //记录中序遍历每个节点的位置和值
            map.put(inorder[i],i);
        }
        return recur(0,0,inorder.length - 1);
    }

    /**
     * 构建子树：以root为根节点，left为构建子树的左边界，right为构建子树的右边界
     */
    private TreeNode recur(int root ,int left , int right) {
        if (left > right) return null; //递归出口：表示已经越过根节点了
        TreeNode node = new TreeNode(preorder[root]);//创建递归的根节点
        int i = map.get(preorder[root]);//从map中找到这次递归的根节点位置，用于区分左右子树
        //左子树：前序遍历：根节点索引 + 1就是左子树的根节点 ，左侧还是left，右侧是中序遍历的根节点-1的位置
        node.left = recur(root + 1, left,i - 1);
        //右子树：前序遍历：左子树的根节点 + 左子树的长度i - left就是右子树的根节点，左侧是中序遍历的根节点+1的位置，右侧是right
        node.right = recur(root + i - left + 1, i + 1,right);
        return node;
    }
}
