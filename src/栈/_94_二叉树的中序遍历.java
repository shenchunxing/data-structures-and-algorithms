package 栈;

import common.TreeNode;

import java.util.*;

/**
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/
 */
/*2023-7-5*/
public class _94_二叉树的中序遍历 {
    public static void main(String[] args) {
        // 构建一棵二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // 测试 inorderTraversal 函数
        List<Integer> result = inorderTraversal(root);
        System.out.println(result);  // 输出: [4，2，5，1，3]
    }
    //迭代O(n) O(n)
    /*通过先遍历左子树，再访问根节点，最后遍历右子树的方式实现中序遍历。
    在遍历过程中，每个节点都会被访问两次，一次是在左子树遍历完成后将其加入结果列表，另一次是在处理完右子树后将其出栈并加入结果列表*/
   static public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        /*cur!= null || !stack.isEmpty() 为了确保遍历能够进行直到所有节点都被处理*/
        while (cur!= null || !stack.isEmpty()) {
            while (cur != null) {  //内层循环：将当前节点 cur 的所有左子节点都入栈，直到左子节点为空
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();//当内层循环结束后，说明当前节点 cur 的左子树已经被完全访问，需要将该节点加入结果列表 ans 中
            ans.add(cur.val);
            cur = cur.right;//将当前节点 cur 更新为其右子节点，继续下一轮循环
        }
        return ans;
    }

    /**
     * 递归 O(n) O(n)
     */
    static public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root,ans);
        return ans;
    }

    static private void inorder(TreeNode root , List<Integer> ans) {
        if (root == null) return;
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }
}
